package com.ams.infomanage.supplier.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.ams.BaseConst;
import com.ams.company.dao.CompanyDao;
import com.ams.company.entity.Company;
import com.ams.company.model.CompanyModel;
import com.ams.infomanage.supplier.dao.SupplierDao;
import com.ams.infomanage.supplier.entity.Supplier;
import com.ams.infomanage.supplier.model.SupplierModel;
import com.core.dao.impl.BaseDaoImpl;
import com.util.page.Pager;

/**
 * 供应商管理
 * @author Wymann
 * @Data 2014-12-12 下午06:12:46
 *
 */
@Repository
public class SupplierDaoImpl extends BaseDaoImpl<Supplier> implements SupplierDao{

	/**
	 * 条件查询
	 * @param model
	 * @param page
	 * @return
	 */
	public List<Supplier> findByCondition(Supplier model, Pager page) {
		log.info("供应商管理条件查询...");
		try{
			StringBuffer sql=new StringBuffer();
			sql.append("select a.supplierId, ");
			sql.append("       a.supplierName, ");
			sql.append("       a.supplierContacts, ");
			sql.append("       a.suppliercontactsPhone ");
			sql.append("  from t_supplier a ");
			sql.append(" where 1 = 1 ");
			if(StringUtils.isNotEmpty(model.getSupplierName())){
				sql.append("   and a.supplierName like '%"+model.getSupplierName()+"%' ");
			}
			if(StringUtils.isNotEmpty(model.getSupplierContacts())){
				sql.append("   and a.supplierContacts = '"+model.getSupplierContacts()+"' ");
			}
	//		if(StringUtils.isNotEmpty(model.getDepartOwner())){
	//			sql.append("   and a.departOwner = '"+model.getDepartOwner()+"' ");
	//		}
			sql.append(" order by a.supplierName asc, a.supplierId asc");
			log.info(sql);
			return jdbcQuery(sql.toString(), page, Supplier.class);
		}catch(RuntimeException e){
			log.error("供应商管理条件查询失败，请检查！", e);
			throw e;
		}
	}

	/**
	 * 根据供应商名称获取供应商信息
	 * @param name
	 * @return
	 */
	public Supplier getByName(String name) {
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
	public List<Supplier> checkSupplier(String name, String id) {
		log.info("检查当前供应商是否存在...");
		try{
			StringBuffer sql=new StringBuffer();
			sql.append("select a.* ");
			sql.append("  from t_supplier a ");
			sql.append(" where a.supplierName = '"+name+"' ");
			if(StringUtils.isNotEmpty(id)){
				sql.append("   and a.supplierId != '"+id+"' ");
			}
			sql.append(" limit 1 ");
			
			return getJdbcTemplate().query(sql.toString(), new BeanPropertyRowMapper<Supplier>(Supplier.class));
		}catch (RuntimeException e) {
			log.error("检查当前供应商是否存在失败，请检查！", e);
			throw e;
		}
	}

}
