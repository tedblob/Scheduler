package com.tedblob.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableAsync
@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(cron = "0 0 6 * * ?")
	public void reportCurrentTime() throws InterruptedException {
		log.info("The time is now {}", dateFormat.format(new Date()));
	}

	@Scheduled(fixedDelay = 3000)
	public void fixedDelay() throws InterruptedException {
		log.info("The time is now {}", dateFormat.format(new Date()));
	}

	@Scheduled(fixedRate = 3000)
	public void fixedRate() throws InterruptedException {
		log.info("The time is now {}", dateFormat.format(new Date()));
	}
}