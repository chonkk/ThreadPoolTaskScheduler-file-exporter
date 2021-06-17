package com.castis.al.scheduler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.castis.al.model.ADDecisionInfo;
import com.castis.al.model.EventLog;
import com.castis.common.util.CiDateUtil;
import com.castis.common.util.CiFileUtils;

public class RunnableTask implements Runnable{
    protected String adDecisionInfoPath;
    protected String eventLogPath;
    protected int idx;
    protected int maxCount;
    protected List<String> categoryIdList;
    protected List<String> campaignIdList;
    
    public RunnableTask(int idx, String adDecisionInfoPath, String eventLogPath, int maxCount, List<String> categoryIdList, List<String> campaignIdList){
        this.adDecisionInfoPath = adDecisionInfoPath;
        this.eventLogPath = eventLogPath;
        this.idx = idx;
        this.maxCount = maxCount;
        this.categoryIdList = categoryIdList;
        this.campaignIdList = campaignIdList;
        
    }
    
    @Override
    public void run() {
    	
    	File tempFilePath = CiFileUtils.openDirectory(adDecisionInfoPath,"temp");
    	File tempFilePath_eventLog =  CiFileUtils.openDirectory(eventLogPath,"temp");
    	
    	String fileName = getFileName();
    	String filenName_eventLog = getFineName_eventLog();

		File file = null;
		File file_eventLog = null;
		String path="";
		String path_eventLog="";
    	try {
			file = CiFileUtils.makeFile(tempFilePath, fileName);
			List<ADDecisionInfo> addiList = getADDI_sample();
			path = file.getAbsolutePath();
			writeFile(file, addiList, true);
			file_eventLog = CiFileUtils.makeFile(tempFilePath_eventLog, filenName_eventLog);
			List<EventLog> eventLogList = getEventLog_sample(addiList);
			path_eventLog = file_eventLog.getAbsolutePath();
			writeFile_eventLog(file_eventLog, eventLogList, true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			if(file!=null) {file=null;}
			if(file_eventLog!=null) {file_eventLog=null;}
		}

        System.out.println(new Date()+Thread.currentThread().getName()+ idx +path+" : "+path_eventLog);
        
        try {
			CiFileUtils.moveFileToDirectory(tempFilePath.getAbsolutePath(), adDecisionInfoPath, fileName, true);
			CiFileUtils.moveFileToDirectory(tempFilePath_eventLog.getAbsolutePath(), eventLogPath, filenName_eventLog, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    protected void writeFile_eventLog(File file, List<EventLog> list, boolean append) {
		if(file==null ) {return;}
		if(list==null || list.isEmpty()) {return;}
		FileOutputStream fileWriter = null;
		OutputStreamWriter outputWriter = null;
		try{
			fileWriter = new FileOutputStream(file, append);
			outputWriter = new OutputStreamWriter(fileWriter);
			for(EventLog info : list) {
				outputWriter.write(info.toString() + "\n");
			}
		}catch(Exception e){
		}finally{
			try{
				outputWriter.close();	outputWriter = null;
				fileWriter.close();		fileWriter = null;
			} catch(Exception e){}
		}
		
	}

    protected List<EventLog> getEventLog_sample(List<ADDecisionInfo> addiList) {
    	
    	if(addiList==null || addiList.isEmpty()) {return null;}
    	
    	List<EventLog> list = new ArrayList<EventLog>();
    	for(ADDecisionInfo info : addiList) {
    		EventLog log = new EventLog(info.getTRACKING(), info.getCAMPAIGN_ID(), info.getCATEGORY_ID(), info.getREQUEST_ID());
    		list.add(log);
    	}
    	
		return list;
	}

	protected List<ADDecisionInfo> getADDI_sample() {
    	List<ADDecisionInfo> list = new ArrayList<ADDecisionInfo>();
    	for(int i=0; i < maxCount; ++i) {
    		ADDecisionInfo info = new ADDecisionInfo();
    		info.setCAMPAIGN_ID(getCampaignId());
    		info.setCATEGORY_ID(getCategoryId());
    		{
        		info.setCATEGORY_NAME(info.getCATEGORY_ID());
    		}
    		list.add(info);
    	}
		return list;
	}

	private String getCategoryId() {
		if(categoryIdList!=null && categoryIdList.isEmpty()==false) {
			//tbd
		}
		
		double ran = Math.random();
		ran  = (ran * 10000) % 100;
		return Integer.toString(Double.valueOf(ran).intValue());
	}

	protected String getCampaignId() {
		if(campaignIdList!=null && campaignIdList.isEmpty()==false) {
			//tbd
		}
		
		double ran = Math.random();
		ran  = (ran * 10000) % 100;
		return Integer.toString(Double.valueOf(ran).intValue());
	}

	protected void writeFile(File file, List<ADDecisionInfo> list, boolean append) {
		if(file==null ) {return;}
		if(list==null || list.isEmpty()) {return;}
		FileOutputStream fileWriter = null;
		OutputStreamWriter outputWriter = null;
		try{
			fileWriter = new FileOutputStream(file, append);
			outputWriter = new OutputStreamWriter(fileWriter);
			for(ADDecisionInfo info : list) {
				outputWriter.write(info.toString() + "\n");
			}
		}catch(Exception e){
		}finally{
			try{
				outputWriter.close();	outputWriter = null;
				fileWriter.close();		fileWriter = null;
			} catch(Exception e){}
		}
		
	}

	protected String getFineName_eventLog() {
		return String.format("sample_vod_%s_%s.csv", idx, CiDateUtil.getyyyyMMddHHmmssSSS());
	}

    protected String getFileName() {
		return String.format("sample_deci_%s_%s.csv", idx, CiDateUtil.getyyyyMMddHHmmssSSS());
	}

}
