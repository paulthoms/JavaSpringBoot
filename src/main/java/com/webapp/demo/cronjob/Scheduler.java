package com.webapp.demo.cronjob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	@Scheduled(cron = "0 * 17 * * ?")
	public void cronJobSch() {
	
		System.out.println("this cron job");
	
	}
}
