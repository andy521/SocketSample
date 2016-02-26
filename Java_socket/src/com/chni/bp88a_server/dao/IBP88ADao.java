package com.chni.bp88a_server.dao;

import java.util.List;

import com.chni.bp88a_server.model.InterveneItems;

public interface IBP88ADao {
	  /**
	   * 查询用户id和体检类型查表名称
	   * @param customerid
	   * @param tableCode
	   * @return
	   */
	  String findTableName(String customerid,String tableCode)throws Exception;
	  /**
	   * 将指标保存导数据库
	   * @param item
	   * @param tableName
	   * @param customerId
	   * @return 
	   * @throws Exception
	   */
	  boolean saveIndicator(InterveneItems item,String tableName,String customerId) throws Exception;
      /**
       * 根据设备的编号获取绑定关系
       * @param customeriId
       * @param deviceSn
       * @return
       * @throws Exception
       */
      String checkUserAndDeviceRelation(String deviceSn)throws Exception;

       
      boolean saveMuchIndicator(List<InterveneItems> item,String tableName,String customerId)throws Exception;

}
