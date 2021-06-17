package com.castis.al.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.castis.common.util.CiDateUtil;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EventLog {
	private String VOD_REQUEST_ID = "VOD_REQUEST_ID";
	 private String CLIENT_ID = "CLIENT_ID";
	 private String CLIENT_IP = "CLIENT_IP";
	 private String FILE_NAME = "FILE_NAME";
	 private String RESULT_TYPE = "RESULT_TYPE";
	 private String PARAMS = "PARAMS";
	 private String SCHEDULE_TIME = "SCHEDULE_TIME";
	 private String MAIN_FILE = "MAIN_FILE";
	 private String START_OFFSET = "START_OFFSET";
	 private String RE_SETUP = "RE_SETUP";
	 private String SESSION_ID = "SESSION_ID";
	 private String START_TIME = "START_TIME";
	 private String END_TIME = "END_TIME";
	 private String TRACKING = "";
	 private String CAMPAIGN_ID = "CAMPAIGN_ID";
	 private String ACCOUNT = "ACCOUNT";
	 private String RESUME = "RESUME";
	 private String CATEGORY_ID = "CATEGORY_ID";
	 private String PRODUCT_TYPE = "PRODUCT_TYPE";
	 private String REGION_ID = "REGION_ID";
	 private String USER_ID = "USER_ID";
	 private String VOD_SERVER_ID = "VOD_SERVER_ID";
	 private String NODE_GROUP_ID="NODE_GROUP_ID";

		//EventLog log = new EventLog(info.getTRACKING(), info.getCAMPAIGN_ID(), info.getCATEGORY_ID(), info.getREQUEST_ID());
	public EventLog(String tracking, String CAMPAIGN_ID, String CATEGORY_ID, String REQUEST_ID) {
		this.setTRACKING(tracking);
		this.setCAMPAIGN_ID(CAMPAIGN_ID);
		this.setCATEGORY_ID(CATEGORY_ID);
		this.setVOD_REQUEST_ID(REQUEST_ID);
		Date curr = CiDateUtil.curr_date();
		this.setSCHEDULE_TIME(CiDateUtil.to_string(curr, "yyyy-MM-dd HH:mm:ss"));
		this.setSTART_TIME(CiDateUtil.to_string(curr, Calendar.SECOND, 2, "yyyy-MM-dd HH:mm:ss"));
		this.setEND_TIME(CiDateUtil.to_string(curr, Calendar.SECOND, 15, "yyyy-MM-dd HH:mm:ss"));
	}

	@Override
	public String toString() {
		return VOD_REQUEST_ID + "|" + CLIENT_ID + "|" + CLIENT_IP
				+ "|" + FILE_NAME + "|" + RESULT_TYPE + "|" + PARAMS
				+ "|" + SCHEDULE_TIME + "|" + MAIN_FILE + "|" + START_OFFSET
				+ "|" + RE_SETUP + "|" + SESSION_ID + "|" + START_TIME + "|"
				+ END_TIME + "|" + TRACKING + "|" + CAMPAIGN_ID + "|" + ACCOUNT
				+ "|" + RESUME + "|" + CATEGORY_ID + "|" + PRODUCT_TYPE
				+ "|" + REGION_ID + "|" + USER_ID + "|" + VOD_SERVER_ID
				+ "|" + NODE_GROUP_ID + "";
	}
}
