package org.burdzi0.bootshorten.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ScheduledRemovingLinksTask {

	private LinkService linkService;
	private Logger logger = LogManager.getLogger();

	public ScheduledRemovingLinksTask(LinkService linkService) {
		this.linkService = linkService;
	}

	@Scheduled(cron = "0 0/30 * ? * *")
	@Transactional
	public void deleteOldLinks() {
		int deleted = linkService.deleteAllOldLinks();
		logger.info("Deleted :" + deleted + " old links");
	}
}
