package com.chni.bp88a_server.service;

import java.util.List;

import com.chni.bp88a_server.model.InterveneItems;

public interface IBP88AService {
	
	  /**
	   * 将指标保存导数据库
	   * @param item
	   * @param tableName
	   * @param customerId
	   * @return 
	   * @throws Exception
	   */
	  boolean saveIndicator(InterveneItems item,String customerId) throws Exception;
     /**
      * 根据设备的编号获取绑定关系
      * @param customeriId
      * @param deviceSn
      * @return
      * @throws Exception
      */
     String checkUserAndDeviceRelation(String deviceSn)throws Exception;


     public boolean saveMuchIndicator(List<InterveneItems> items,
 			String customerId) throws Exception ;
     

}
