package com.chni.bp88a_server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.chni.bp88a_server.model.InerAnalysis;
import com.chni.bp88a_server.model.InterveneItems;
import com.chni.bp88a_server.utils.DBUtil;
import com.chni.bp88a_server.utils.DateMsg;

public class BP88ADaoImpl implements IBP88ADao {
	

    @Override
	public   String findTableName(String customerid, String tableCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String tablename = "";
		try {
			conn = DBUtil.getConn();
			String sql = "select * from cus_customertableinfo_b where customerid=? and tablecode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customerid);
			pstmt.setString(2, tableCode);
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				tablename =  resultSet.getString("tablename");
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(resultSet, pstmt, conn);
		}
		return tablename;
	}

    @Override
	public   boolean saveIndicator(InterveneItems item,String tableName,String customerId) throws Exception{
		String nowd = DateMsg.getNowDate(1);
		List<InerAnalysis> listInerAnalysisInsert = new ArrayList<InerAnalysis>();
		
		if(item!=null&&item.getHr()!=null&&item.getPbg()!=null &&item.getSbp()!=null){
			String val = item.getSbp() + "Ъ" + item.getPbg();
			listInerAnalysisInsert.add(getInerAnalysis("IA-012", nowd,
					customerId, item.getEntyDate(), val, customerId));
			listInerAnalysisInsert.add(getInerAnalysis("IA-000", nowd,
					customerId, item.getEntyDate(), item.getHr(),
					customerId));
		}
		boolean  flag = false;
		if(listInerAnalysisInsert!=null &&listInerAnalysisInsert.size()>0){
			flag = saveInterveneItem(listInerAnalysisInsert, tableName);
		}else{
			flag = false;
		}
		return flag;
		
	} 
	
	/**
	 * 查询当前数据是否已经存在
	 * @param val
	 * @param now
	 * @param customerId
	 * @param tableName
	 * @return
	 * @throws Exception 
	 */
	public static boolean findExit(String val, String now, String customerId,
			String tableName) throws ClassNotFoundException, SQLException {
		boolean b = true;
		String sql = "select * from " + tableName
				+ " where  customerid=? and questionid=? and entrydate=? ";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, customerId);
			ps.setString(2, val);
			ps.setString(3, now);
			rs = ps.executeQuery();
			while (rs.next()) {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(rs, ps, conn);
		}
		return b;
	}
	
	private static InerAnalysis getInerAnalysis(String questionid, String createtime,
			String customerId, String entrydate, String value,
			String createuserid) {
		InerAnalysis inerAnalysis = new InerAnalysis();
		inerAnalysis.setCreatetime(createtime);
		inerAnalysis.setCustomerid(customerId);
		inerAnalysis.setEntrydate(entrydate);
		inerAnalysis.setQuestionid(questionid);
		inerAnalysis.setSource("3");
		inerAnalysis.setValue(value);
		inerAnalysis.setCreateuserid(createuserid);
		return inerAnalysis;
	}
	
	public static boolean saveInterveneItem(List<InerAnalysis> listInerAnalysis,
			String tableName) throws Exception {
		PreparedStatement ps = null;
		Connection conn =null;
		boolean b = true;
		try {
			 conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			for (int i = 0; i < listInerAnalysis.size(); i++) {
				String sql = "insert   into   "
						+ tableName
						+ "(customerid,questionid,value,createtime,source,createuserid,entrydate,client,cdescribe,datatype,datadesc)   "
						+ "values(?,?,?,?,?,?,?,?,?,?,?) ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, listInerAnalysis.get(i).getCustomerid());
				ps.setString(2, listInerAnalysis.get(i).getQuestionid());
				ps.setString(3, listInerAnalysis.get(i).getValue());
				ps.setString(4, listInerAnalysis.get(i).getCreatetime());
				ps.setString(5, "3");
				ps.setString(6, "1");
				ps.setString(7, listInerAnalysis.get(i).getEntrydate());
				ps.setString(8, "3");
	            ps.setString(9, "--");
	            ps.setString(10, "1");
	            ps.setString(11, "");
				ps.execute();
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			b = false;
		} finally {
			DBUtil.closeDB(null, ps, conn);
		}
		return b;
	}
	
	@Override
	public String checkUserAndDeviceRelation(String deviceSn) throws Exception {
		String customerid = "";
		String sql = "select * from cus_device_binding  where  device_sn=? ";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, deviceSn);
			rs = ps.executeQuery();
			if (rs.next()) {
				customerid =  rs.getString("customerid");
			}
		}finally {
			DBUtil.closeDB(rs, ps, conn);
		}
		return customerid;
	}
	
	public static void main(String[] args) {
		
	}

	@Override
	public boolean saveMuchIndicator(List<InterveneItems> items, String tableName,
			String customerId) throws Exception {
		boolean[] isNotSuccess = new boolean[items.size()];
		for (int i = 0; i < items.size(); i++) {
			String nowd = DateMsg.addDate(1);
			InterveneItems item= items.get(i);
			List<InerAnalysis> listInerAnalysisInsert = new ArrayList<InerAnalysis>();
			if(item!=null&&item.getHr()!=null&&item.getPbg()!=null &&item.getSbp()!=null){
				String val = item.getSbp() + "Ъ" + item.getPbg();
				listInerAnalysisInsert.add(getInerAnalysis("IA-012", nowd,
						customerId, item.getEntyDate(), val, customerId));
				listInerAnalysisInsert.add(getInerAnalysis("IA-000", nowd,
						customerId, item.getEntyDate(), item.getHr(),
						customerId));
			}
			
			boolean saveIndicator = saveInterveneItem(listInerAnalysisInsert, tableName);
			listInerAnalysisInsert.clear();
			isNotSuccess[i]=saveIndicator;
		}
		int total = 0;
		for (int i = 0; i < isNotSuccess.length; i++) {
			if (isNotSuccess[i] == true) {
				total++;
			}
		}
		
		System.out.println("返回结果:" + "total="+total);
		System.out.println("返回结果:" + "isNotSuccess="+Arrays.toString(isNotSuccess));
		if (isNotSuccess.length == total) {
			return true;
		}else{
			return false;
		}
		
	}

	
	
}
