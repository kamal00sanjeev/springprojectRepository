/**
 * 
 */
package com.sb.schedule.action;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Sanjeev
 *
 */
@Component
public class ScheduleTask {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public ScheduleTask() {
	}
	
	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void run1() {
	    logger.info("Current time1 is :: " + Calendar.getInstance().getTime());
	}
	
	@Scheduled(cron = "0 10 10 10 * ?")
	public void run2() {
	    logger.info("Current time2 is :: " + Calendar.getInstance().getTime());
	}

}
