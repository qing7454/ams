package com.ams.infomanage.maintenanceinfo.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.ams.BaseConst;
import com.ams.company.dao.CompanyDao;
import com.ams.company.entity.Company;
import com.ams.company.model.CompanyModel;
import com.ams.infomanage.maintenanceinfo.dao.MaintenanceinfoDao;
import com.ams.infomanage.maintenanceinfo.entity.Maintenanceinfo;
import com.ams.infomanage.maintenanceinfo.model.MaintenanceinfoModel;
import com.core.dao.impl.BaseDaoImpl;
import com.util.page.Pager;

/**
 * 维护公司信息管理
 * @author Wymann
 * @Data 2014-12-12 下午06:12:46
 *
 */
@Repository
public class MaintenanceinfoDaoImpl extends BaseDaoImpl<Maintenanceinfo> implements MaintenanceinfoDao{

	/**
	 * 条件查询
	 * @param model
	 * @param page
	 * @return
	 */
	public List<Maintenanceinfo> findByCondition(Maintenanceinfo model, Pager page) {
		log.info("维护公司信息管理条件查询...");
		try{
			StringBuffer sql=new StringBuffer();
			sql.append("select a.maintenanceId, ");
			sql.append("       a.maintenanceName, ");
			sql.append("       a.maintenanceContacts, ");
			sql.append("       a.maintenanceContactsPhone ");
			sql.append("  from t_maintenanceinfo a ");
			sql.append(" where 1 = 1 ");
			if(StringUtils.isNotEmpty(model.getMaintenanceName())){
				sql.append("   and a.maintenanceName like '%"+model.getMaintenanceName()+"%' ");
			}
			if(StringUtils.isNotEmpty(model.getMaintenanceContacts())){
				sql.append("   and a.maintenanceContacts like '%"+model.getMaintenanceContacts()+"%' ");
			}
			/*if(StringUtils.isNotEmpty(model.getMaintenanceContactsPhone())){
				sql.append("   and a.maintenanceContactsPhone = '"+model.getMaintenanceContactsPhone()+"' ");
			}*/
			sql.append(" order by a.maintenanceName asc, a.maintenanceContacts asc");
			log.info(sql);
			return jdbcQuery(sql.toString(), page, Maintenanceinfo.class);
		}catch(RuntimeException e){
			log.error("维护公司信息管理条件查询失败，请检查！", e);
			throw e;
		}
	}

	/**
	 * 根据维护公司名称获取维护公司信息
	 * @param name
	 * @return
	 */
	public Maintenanceinfo getByName(String name) {
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
	public List<Maintenanceinfo> checkMaintenanceinfo(String name, String id) {
		log.info("检查当前维护公司名称是否存在...");
		try{
			StringBuffer sql=new StringBuffer();
			sql.append("select a.* ");
			sql.append("  from t_maintenanceinfo a ");
			sql.append(" where a.maintenanceName = '"+name+"' ");
			if(StringUtils.isNotEmpty(id)){
				sql.append("   and a.maintenanceId != '"+id+"' ");
			}
			sql.append(" limit 1 ");
			
			return getJdbcTemplate().query(sql.toString(), new BeanPropertyRowMapper<Maintenanceinfo>(Maintenanceinfo.class));
		}catch (RuntimeException e) {
			log.error("检查当前维护公司名称是否存在失败，请检查！", e);
			throw e;
		}
	}

}
