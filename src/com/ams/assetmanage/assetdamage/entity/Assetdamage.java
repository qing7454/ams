package com.ams.assetmanage.assetdamage.entity;

import java.sql.Timestamp;

/**
 * 资产报损实体
 */
    public class Assetdamage {

    	private String assetDamageID;      // 主键
    	private String assetId;            // 资产编号
    	private String assetDamageRemark;  // 损坏原因
    	private String assetDamageReason;  //报损理由
    	private String assetDamageOpinion; //鉴定意见
    	private int userId;             //鉴定人编号
    	private Timestamp appDate;            //鉴定时间
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
    	public int getUserId() {
    		return userId;
    	}
    	public void setUserId(int userId) {
    		this.userId = userId;
    	}
    	public Timestamp getAppDate() {
    		return appDate;
    	}
    	public void setAppDate(Timestamp appDate) {
    		this.appDate = appDate;
    	}
    	public String getLastOpinion() {
    		return lastOpinion;
    	}
    	public void setLastOpinion(String lastOpinion) {
    		this.lastOpinion = lastOpinion;
    	}
}
