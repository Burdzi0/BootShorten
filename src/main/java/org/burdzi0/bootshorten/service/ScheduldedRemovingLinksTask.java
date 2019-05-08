package org.burdzi0.bootshorten.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduldedRemovingLinksTask {

	private LinkService linkService;
	private Logger logger = LogManager.getLogger();

	public ScheduldedRemovingLinksTask(LinkService linkService) {
		this.linkService = linkService;
	}

	@Scheduled(cron = "* * * * *")
	public void deleteOldLinks() { //TODO Test delete old links schedulded task
		int deleted = linkService.deleteAllOldLinks();
		logger.info("Deleted :" + deleted + " old links");
	}
}
