package com.chni.bp88a_server.service;

import java.util.List;

import com.chni.bp88a_server.dao.IBP88ADao;
import com.chni.bp88a_server.model.InterveneItems;
import com.chni.bp88a_server.utils.BeanFactory;

public class BP88AServiceImpl implements IBP88AService {

	@Override
	public String checkUserAndDeviceRelation(String deviceSn) throws Exception {
		IBP88ADao dao = (IBP88ADao) BeanFactory.getBean("IBP88ADao");
		String customerId = dao.checkUserAndDeviceRelation(deviceSn);
		return customerId;
	}

	@Override
	public boolean saveIndicator(InterveneItems item,
			String customerId) throws Exception {
		IBP88ADao dao = (IBP88ADao) BeanFactory.getBean("IBP88ADao");
		String tableName = dao.findTableName(customerId, "bodycheckitem");
		boolean b = dao.saveIndicator(item, tableName,customerId);
		if (b) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean saveMuchIndicator(List<InterveneItems> items,
		 String customerId) throws Exception {
		IBP88ADao dao = (IBP88ADao) BeanFactory.getBean("IBP88ADao");
		String tableName = dao.findTableName(customerId, "bodycheckitem");
		boolean b = dao.saveMuchIndicator(items, tableName, customerId);
		if (b) {
			return true;
		} else {
			return false;
		}
	}

}
