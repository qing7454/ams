package com.ams.assetmanage.assetdamage.model;

import java.sql.Timestamp;

/**
 * 资产报损视图模型
 * 
 * @author 
 * 
 * 
 */
public class AssetdamageModel {
	private String assetDamageID;      // 主键
	private String assetId;            // 资产编号
	private String assetDamageRemark;  // 损坏原因
	private String assetDamageReason;  //报损理由
	private String assetDamageOpinion; //鉴定意见
	private String userId;             //鉴定人编号
	private String appDate;         //鉴定时间    Timestamp
	private String lastOpinion;        //审批意见
	
	public String getAssetDamageID() {
		return assetDamageID;
	}
	public void setAssetDamageID(String assetDamageID) {
		this.assetDamageID = assetDamageID;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public String getAssetDamageRemark() {
		return assetDamageRemark;
	}
	public void setAssetDamageRemark(String assetDamageRemark) {
		this.assetDamageRemark = assetDamageRemark;
	}
	public String getAssetDamageReason() {
		return assetDamageReason;
	}
	public void setAssetDamageReason(String assetDamageReason) {
		this.assetDamageReason = assetDamageReason;
	}
	public String getAssetDamageOpinion() {
		return assetDamageOpinion;
	}
	public void setAssetDamageOpinion(String assetDamageOpinion) {
		this.assetDamageOpinion = assetDamageOpinion;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public String getLastOpinion() {
		return lastOpinion;
	}
	public void setLastOpinion(String lastOpinion) {
		this.lastOpinion = lastOpinion;
	}
}
