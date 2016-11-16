package com.ams.assetmanage.maintenanceRecord.dao;

import java.util.List;

import com.ams.assetmanage.assetinf.model.AssetinfModel;
import com.ams.assetmanage.maintenanceRecord.entity.MaintenanceRecord;
import com.ams.assetmanage.maintenanceRecord.model.MaintenanceRecordModel;
import com.core.dao.BaseDao;
import com.util.page.Pager;

public interface MaintenanceRecordDao extends BaseDao<MaintenanceRecord> {

	/**
	 * 条件查询
	 * @param model
	 * @param pager
	 * @return
	 */
	List<MaintenanceRecordModel> findByCondition(MaintenanceRecordModel model,Pager page);
	
	
	/**
	 * 根据资产id获取维护记录model
	 * @param id
	 * @return
	 */
	MaintenanceRecordModel getModel(String id);


	/**
	 * 检查当前资产维护记录是否存在
	 * @param name
	 * @param id
	 * @return
	 */
	List<MaintenanceRecord> checkMaintenanceRecord(String name, String id);
	

}
