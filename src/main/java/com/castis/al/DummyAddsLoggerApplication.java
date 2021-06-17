package com.castis.al;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.castis.al.service.SchedulerService;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages="com.castis")
public class DummyAddsLoggerApplication {
	
	@Autowired
    private SchedulerService schedulerService;

	public static void main(String[] args) {
		SpringApplication.run(DummyAddsLoggerApplication.class, args);
	}
	

	@Bean
    public ApplicationRunner applicationRunner(String... args) throws Exception {
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {
				List<String> optList = args.getNonOptionArgs();
				int count = 1;
				long delay = 10000;
				int maxCount = 500;
			    String adDecisionInfoPath="./temp";
			    String eventLogPath = "./temp";
				if(optList!=null ) {
					
					if(optList.size()> 0) {
						count = Integer.parseInt(optList.get(0));
					}
					
					if(optList.size()> 1) {
						maxCount = Integer.parseInt(optList.get(1));
					}
					
					if(optList.size()> 2) {
						delay = Long.parseLong(optList.get(2));
					}
					
					if(optList.size()> 3) {
						adDecisionInfoPath = optList.get(3);
					}
					
					if(optList.size()> 4) {
						eventLogPath = optList.get(4);
					}
				}
				schedulerService.start(count, delay, adDecisionInfoPath, eventLogPath, maxCount);
			}
		};
    }
}
