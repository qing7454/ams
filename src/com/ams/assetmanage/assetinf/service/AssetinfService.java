package com.ams.assetmanage.assetinf.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.ams.assetmanage.assetinf.entity.Assetinf;
import com.ams.assetmanage.assetinf.model.AssetinfModel;
import com.util.page.Pager;

/**
 * 资产信息管理
 * 
 * @author 
 * @Data 
 * 
 */
public interface AssetinfService {

	/**
	 * 保存资产
	 * 
	 * @param model
	 * @return
	 */
	Assetinf save(Assetinf model);

	/**
	 * 修改资产
	 * 
	 * @param model
	 * @return
	 */
	Assetinf update(Assetinf model);

	/**
	 * 删除资产信息
	 * 
	 * @param id
	 */
	void delete(String id);

	/**
	 * 根据id查找资产信息
	 * 
	 * @param id
	 * @return
	 */
	Assetinf getById(String id);

	/**
	 * 条件查询
	 * 
	 * @param model
	 * @param page
	 * @return
	 */
	List<Assetinf> findByCondition(Assetinf model, Pager page);

	/**
	 * 视图条件查询
	 * @param model
	 * @param page
	 * @return
	 */
	List<AssetinfModel> findModelByCondition(AssetinfModel model, Pager page);
	
	/**
	 * 检查资产是否存在
	 * 
	 * @param name
	 * @return
	 */
	boolean checkAssetinf(String id);

	/**
	 * 根据资产名id获取资产信息
	 * 
	 * @param id
	 * @return
	 */
	Assetinf getByName(String name);
	
	/***
	 * 根据id查询model
	 * @author simon
	 * @date 2016年11月15日 下午12:54:00
	 * @param id
	 * @return
	 */
	AssetinfModel getModelById(String id);
	
	/***
	 * 导出资产信息excel
	 * @author simon
	 * @date 2017年1月18日 下午2:44:52
	 * @param list
	 * @param excelPath
	 * @return
	 */
	String exportExcel(List<AssetinfModel> list,String excelPath);
	
	/***
	 * 统计资产数量 通过资产类型
	 * @author simon
	 * @date 2017年1月18日 下午3:13:16
	 * @return 含有value和name两列值的数据集
	 */
	List<Map<String, Object>> getCountByAssettype();
}
