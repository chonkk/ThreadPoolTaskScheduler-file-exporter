package com.castis.al.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class ThreadPoolTaskSchedulerConfig{

	 @Bean
	    public ThreadPoolTaskScheduler schedulerExecutor() {
	        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
	        taskScheduler.setPoolSize(10);
	        taskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
	        return taskScheduler;

	    }
}
