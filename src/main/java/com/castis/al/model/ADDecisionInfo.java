package com.castis.al.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.castis.common.util.CiDateUtil;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ADDecisionInfo {
 private String TRACKING = "";
 private String REQUEST_ID = "";
 private String AD_ID = "AD_ID";
 private String CAMPAIGN_ID = "";
 private String AD_ASSET_ID = "AD_ASSET_ID";
 private String SLOT_ID = "SLOT_ID";
 private String PO_TYPE = "PO_TYPE";
 private String PO_ID  = "PO_ID";
 private String PO_TIME = "PO_TIME";
 private String AD_FILE_NAME = "AD_FILE_NAME";
 private String AD_DECISION_TIME = "";
 private String LOG_DATE = "";
 private String USER_ID = "USER_ID";
 private String USER_DOMAIN_ID = "USER_DOMAIN_ID";
 private String USER_DEVICE_TYPE = "USER_DEVICE_TYPE";
 private String CATEGORY_ID = "CATEGORY_ID";
 private String CATEGORY_NAME = "CATEGORY_NAME";
 private String ASSET_ID = "ASSET_ID";
 private String GENRE = "GENRE";
 private String PROVIDER = "PROVIDER";
 private String PROVIDER_ID = "PROVIDER_ID";
 private String RATING = "RATING";
 private String RUNNING_TIME = "RUNNING_TIME";
 private String REGION_ID = "REGION_ID";
 private String RESUME = "RESUME";
 private String PAY_AMOUNT = "PAY_AMOUNT";
 private String PRODUCT_TYPE = "PRODUCT_TYPE";
 private String MAPPED_MSO_CODE = "MAPPED_MSO_CODE";
 private String MAPPED_CP_CODE = "MAPPED_CP_CODE";
 private String MAPPED_TIME_ID = "MAPPED_TIME_ID";
 private String MAPPED_REGION_ID = "MAPPED_REGION_ID";
 private String MAPPED_CATEGORY_ID = "MAPPED_CATEGORY_ID";
 private String REPORTING_CD = "REPORTING_CD";
 private String ADDS_FE_SERVER_ID = "ADDS_FE_SERVER_ID";

	@Override
	public String toString() {
		return TRACKING + "|" + REQUEST_ID + "|" + AD_ID + "|" + CAMPAIGN_ID + "|" + AD_ASSET_ID + "|" + SLOT_ID + "|" + PO_TYPE + "|" 
				+ PO_ID + "|" + PO_TIME + "|" + AD_FILE_NAME + "|" + AD_DECISION_TIME + "|" + LOG_DATE + "|" + USER_ID + "|" + USER_DOMAIN_ID + "|" + USER_DEVICE_TYPE + "|" 
				+ CATEGORY_ID + "|" + CATEGORY_NAME + "|" + ASSET_ID + "|" + GENRE + "|" + PROVIDER + "|" + PROVIDER_ID + "|" + RATING + "|" + RUNNING_TIME + "|" + REGION_ID 
				+ "|" + RESUME + "|" + PAY_AMOUNT + "|" + PRODUCT_TYPE + "|" + MAPPED_MSO_CODE + "|" + MAPPED_CP_CODE + "|" + MAPPED_TIME_ID + "|" + MAPPED_REGION_ID + "|" 
				+ MAPPED_CATEGORY_ID + "|" + REPORTING_CD + "|" + ADDS_FE_SERVER_ID;
	}

	public ADDecisionInfo() {
		super();
		this.setTRACKING(UUID.randomUUID().toString().replace("-", ""));
		this.setREQUEST_ID(UUID.randomUUID().toString().replace("-", ""));
		Date date = new Date();
		this.setLOG_DATE(CiDateUtil.to_string(date, "yyyy-MM-dd HH:mm:ss"));
		this.setAD_DECISION_TIME(CiDateUtil.to_string(date,Calendar.SECOND,-50, "yyyy-MM-dd HH:mm:ss"));
		
	}
}
