package com.chni.bp88a_server.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import com.chni.bp88a_server.model.InterveneItems;
import com.chni.bp88a_server.model.SocketRequest;
import com.chni.bp88a_server.model.SocketResponse;
import com.chni.bp88a_server.service.IBP88AService;
import com.chni.bp88a_server.utils.BeanFactory;
import com.chni.bp88a_server.utils.DataParseUtil;
import com.chni.bp88a_server.utils.DateMsg;
import com.chni.bp88a_server.utils.HexUtils;

public class BP88AController {

	private static final Logger log = Logger.getLogger(BP88AController.class);

	public void execute(SocketRequest req, SocketResponse resp)
			throws Exception {
		IBP88AService service = (IBP88AService) BeanFactory
				.getBean("IBP88AService");
		if ("01".equals(req.getOperation())) {
			log.info("获取传入的数据:" + req.getData());
			// 1.获取参数中的中的当前时间
			String date = req.getData().substring(req.getLength() * 2 - 12,
					req.getLength() * 2 - 2);
			log.info("date=" + date);
			StringBuffer sBuffer = new StringBuffer();
			sBuffer.append("20").append(DataParseUtil.parseDate(date)[0])
					.append(DataParseUtil.parseDate(date)[1]).append(
							DataParseUtil.parseDate(date)[2]).append(
							DataParseUtil.parseDate(date)[3]).append(
							DataParseUtil.parseDate(date)[4]).append("00");
			String date1 = sBuffer.toString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			long millionSeconds = sdf.parse(date1).getTime();// 毫秒
			
			long currentTimeMillis = System.currentTimeMillis();
			if (currentTimeMillis - millionSeconds < 10 * 60 * 1000) {// 时间在10分钟之内，返回应答结果
				byte[] bytes = new byte[7];
				bytes[0] =(byte) 170;
				bytes[1] = (byte) 128;
				bytes[2] = 5;
				bytes[3] = 2;
				bytes[4] = 1;
				bytes[5] = 0;
				bytes[6] = 6;
				resp.setData(bytes);
				resp.setOper("01");
			} else {
				String rDate = sdf.format(new Date(currentTimeMillis));
				rDate = rDate.substring(2, rDate.length() - 2);
				// 将其转换为16进制
				log.info("rDate=" + rDate);
				rDate = DataParseUtil.parseDateHex(rDate);
				byte[] bytes = HexUtils.getHexBytes(rDate);
				byte strs = 0x05 ^ 0x06 ^ 0x02;// 异或运算
				for (int i = 0; i < bytes.length; i++) {
					strs ^= bytes[i];
				}
				String[] str = new String[5];// 存放转换后数据
				for (int i = 0; i < bytes.length; i++) {
					if (bytes[i] + "".length() < 2) {
						str[i] = "0" + bytes[i];
					} else {
						str[i] = "" + bytes[i];
					}
				}
				StringBuffer ss = new StringBuffer();
				if (strs + "".length() < 2) {// 长度小于2位补0
					ss.append("0").append(strs + "");
				} else {
					ss.append(strs);
				}
				String sss = ss.toString();
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("aa80050602").append(str[0]).append(str[1])
						.append(str[2]).append(bytes[3]).append(str[4]).append(
								sss);
				resp.setData(HexUtils.getHexBytes(stringBuffer.toString()));
			}
		} else if ("03".equals(req.getOperation())) {// 处理上传本次监测数据
			log.info("获取传入的数据：" + req.getData());
			String bloodPressure = req.getData().substring(
					req.getLength() * 2 - 12, req.getLength() * 2 - 2);
			log.info("bloodPressure====" + bloodPressure);
			String date = req.getData().substring(req.getLength() * 2 - 22,
					req.getLength() * 2 - 12);
			log.info("date====" + date);
			String device_sn = req.getData().substring(
					req.getLength() * 2 - 32, req.getLength() * 2 - 22);
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(DataParseUtil.parseDevicSn(device_sn)[0])
					.append(DataParseUtil.parseDevicSn(device_sn)[1]).append(
							DataParseUtil.parseDevicSn(device_sn)[2]).append(
							DataParseUtil.parseDevicSn(device_sn)[3]);
			log.info("设备序号:" + stringBuffer.toString());
			device_sn = stringBuffer.toString();
			// 1、根据设备的序号在数据库
			String customerid = service.checkUserAndDeviceRelation(device_sn);
			// 2、插入数据
			InterveneItems item = new InterveneItems();
			item.setHr(DataParseUtil.parseBloodPressure(bloodPressure)[2]);
			item.setSbp(DataParseUtil.parseBloodPressure(bloodPressure)[0]);
			item.setPbg(DataParseUtil.parseBloodPressure(bloodPressure)[1]);
			item.setEntyDate(DateMsg.getNowDate(1));
			boolean saveIndicator = service.saveIndicator(item, customerid);
			if (saveIndicator) {
				byte[] bytes = new byte[7];
				bytes[0] =(byte) 170;
				bytes[1] = (byte) 128;
				bytes[2] = 5;
				bytes[3] = 2;
				bytes[4] = 3;
				bytes[5] = 0;
				bytes[6] = 4;
				resp.setData(bytes);
				resp.setOper("03");
			} else {
				byte[] bytes = new byte[7];
				bytes[0] = (byte) 170;
				bytes[1] =  (byte) 128;
				bytes[2] = 5;
				bytes[3] = 2;
				bytes[4] = 3;
				bytes[5] = 1;
				bytes[6] = 5;
				resp.setData(bytes);
				resp.setOper("03");
			}
		} else if ("04".equals(req.getOperation())) {
			log.info("获取传入的数据：" + req.getData());
			// 1.获取设备编号
			String device_sn = req.getData().substring(16, 26);
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(DataParseUtil.parseDevicSn(device_sn)[0])
					.append(DataParseUtil.parseDevicSn(device_sn)[1]).append(
							DataParseUtil.parseDevicSn(device_sn)[2]).append(
							DataParseUtil.parseDevicSn(device_sn)[3]);
			device_sn = stringBuffer.toString();
			log.info("设备序号:" + device_sn);
			// 2.获取传入的数据的组数
			String dataNumbers = req.getData().substring(26, 28);// 数据的个数
			int dateNumber1 = Integer.parseInt(dataNumbers, 16);
			log.info("数据的组数" + dateNumber1);
			// 3.获取各组中的数据
			String dataSet = req.getData().substring(28,
					req.getLength() * 2 - 2);
			log.info("数据源" + dataSet);
			String[] sub5String = DataParseUtil.sub5String(dataSet);
			List<String> dateSet = new ArrayList<String>();
			List<String> bloodPressSet = new ArrayList<String>();
			for (int i = 0; i < sub5String.length; i++) {
				if (i % 2 == 0) {
					dateSet.add(sub5String[i]);
				} else {
					bloodPressSet.add(sub5String[i]);
				}
			}
			
			List<InterveneItems> liInterveneItems = new ArrayList<InterveneItems>();
			for (int i = 0; i < dateSet.size(); i++) {
				InterveneItems interveneItems = new InterveneItems();
				StringBuffer s = new StringBuffer();
				StringBuffer s1 = new StringBuffer();
				String[] parseDate = DataParseUtil.parseDate(dateSet.get(i));
				for (int j = 0; j < parseDate.length; j++) {
					s.append(parseDate[j]);
				}
				interveneItems.setEntyDate(DateMsg.parseDate(s1.append("20").append(s.append("00"))
						.toString()));
				interveneItems.setSbp(DataParseUtil
							.parseBloodPressure(bloodPressSet.get(i))[0]);
				interveneItems.setPbg(DataParseUtil
							.parseBloodPressure(bloodPressSet.get(i))[1]);
				interveneItems.setHr(DataParseUtil
							.parseBloodPressure(bloodPressSet.get(i))[2]);
				liInterveneItems.add(interveneItems);
			}
			// 1、根据设备的序号在数据库
			String customerid = service.checkUserAndDeviceRelation(device_sn);
			// 2.插入数据
			boolean saveMuchIndicator = service.saveMuchIndicator(liInterveneItems, customerid);
			if (saveMuchIndicator) {
				byte[] bytes = new byte[7];
				bytes[0] =(byte) 170;
				bytes[1] = (byte) 128;
				bytes[2] = 5;
				bytes[3] = 2;
				bytes[4] = 4;
				bytes[5] = 0;
				bytes[6] = 3;
				resp.setData(bytes);
			} else {
				byte[] bytes = new byte[7];
				bytes[0] =(byte) 170;
				bytes[1] = (byte) 128;
				bytes[2] = 5;
				bytes[3] = 2;
				bytes[4] = 4;
				bytes[5] = 1;
				bytes[6] = 2;
				resp.setData(bytes);
			}
		}
	}
}
