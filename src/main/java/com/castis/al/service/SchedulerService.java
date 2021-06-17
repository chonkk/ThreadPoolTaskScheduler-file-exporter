package com.castis.al.service;


import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import com.castis.al.config.ADDSConfig;
import com.castis.al.scheduler.RunnableTask;
import com.castis.common.util.CiDateUtil;

@Service
public class SchedulerService {
	
	@Autowired
	private ThreadPoolTaskScheduler schedulerExecutor;
	
	@Autowired
	private ADDSConfig addsConfig;
	
    public SchedulerService() {
    }

    public void start(int count, long delay,String adDecisionInfoPath, String eventLogPath, int maxCount) {
    	if(count < 1) {return;}
    	if(delay < 0) {return;}
    	if(schedulerExecutor.getPoolSize() < count) {
    		schedulerExecutor.setPoolSize(count);
    	}
    	
    	int interval = (int) (delay / (long)(count*1000));
    	
    	
    	Date date = new Date();
    	for(int i = 0; i < count; ++i) {
    		RunnableTask task = new RunnableTask(i, adDecisionInfoPath, eventLogPath, maxCount, addsConfig.getCategoryIdList(), addsConfig.getCampaignIdList());
    		schedulerExecutor.scheduleWithFixedDelay(task,CiDateUtil.add(date, Calendar.SECOND,  i * interval), delay);
    	}
    	
    }

}

