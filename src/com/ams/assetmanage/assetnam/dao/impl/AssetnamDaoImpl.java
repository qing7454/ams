﻿package com.ams.assetmanage.assetnam.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.ams.BaseConst;
import com.ams.company.dao.CompanyDao;
import com.ams.company.entity.Company;
import com.ams.company.model.CompanyModel;
import com.ams.assetmanage.assetnam.dao.AssetnamDao;
import com.ams.assetmanage.assetnam.entity.Assetnam;
import com.ams.assetmanage.assetnam.model.AssetnamModel;
import com.core.dao.impl.BaseDaoImpl;
import com.util.page.Pager;

/**
 * 资产名称信息管理
 * @author 
 * @Data 
 *
 */
@Repository
public class AssetnamDaoImpl extends BaseDaoImpl<Assetnam> implements AssetnamDao{

	/**
	 * 条件查询
	 * @param model
	 * @param page
	 * @return
	 */
	public List<Assetnam> findByCondition(Assetnam model, Pager page) {
		log.info("资产名称信息管理条件查询...");
		try{
			StringBuffer sql=new StringBuffer();
			sql.append("select a.assetnameId, ");
			sql.append("       a.assetName, ");
			sql.append("b.assettypename as assetType ");
			sql.append("  from t_assetname a LEFT JOIN t_assettype b ON a.assetType = b.assettypeid");
			sql.append(" where 1 = 1 ");
			/*
                        if(StringUtils.isNotEmpty(model.getassetnameId())){
				sql.append("   and a.assetnameId like '"+model.getassetnameId()+"' ");
			}*/
                        if(StringUtils.isNotEmpty(model.getassetName())){
				sql.append("   and a.assetName like '%"+model.getassetName()+"%' ");
			}
			           if(StringUtils.isNotEmpty(model.getassetType())){
				sql.append("   and b.assettypename = '"+model.getassetType()+"' ");
			}
			
		    
			sql.append(" order by a.assetName asc, a.assetType asc");
			log.info(sql);
			return jdbcQuery(sql.toString(), page, Assetnam.class);
		  }
		    catch(RuntimeException e){
			log.error("资产名称信息管理条件查询失败，请检查！", e);
			throw e;
		    }
	}
	

	/**
	 * 根据资产名称获取资产名称信息
	 * @param name
	 * @return
	 */
	public Assetnam getByName(String name) {
		/*log.info("根据单位名称获取单位信息...");
		try{
			StringBuffer sql=new StringBuffer();
			sql.append("select a.* ");
			sql.append("  from t_company a ");
			sql.append(" where a.company_Name = '"+name+"' ");
			sql.append(" limit 1 ");
			List<Company> list=getJdbcTemplate().query(sql.toString(), new BeanPropertyRowMapper<Company>(Company.class));
			if(!list.isEmpty() && list.size()>0){
				return list.get(0);
			}
			return null;
		}catch (RuntimeException e) {
			log.error("根据单位名称获取单位信息失败，请检查！", e);
			throw e;
		}*/
		log.info("未定义函数功能");
		return null;
	}

	@Override
	public List<Assetnam> checkAssetnam(String name, String id) {
		log.info("检查当前资产名称是否存在...");
		try{
			StringBuffer sql=new StringBuffer();
			sql.append("select a.* ");
			sql.append("  from t_assetname a ");
			sql.append(" where a.assetName = '"+name+"' ");
			if(StringUtils.isNotEmpty(id)){
				sql.append("   and a.assetnameId != '"+id+"' ");
			}
			sql.append(" limit 1 ");
			
			return getJdbcTemplate().query(sql.toString(), new BeanPropertyRowMapper<Assetnam>(Assetnam.class));
		}catch (RuntimeException e) {
			log.error("检查当前资产名称是否存在失败，请检查！", e);
			throw e;
		}
	}

}
