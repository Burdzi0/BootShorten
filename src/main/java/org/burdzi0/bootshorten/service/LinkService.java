package org.burdzi0.bootshorten.service;

import org.burdzi0.bootshorten.model.Link;

public interface LinkService extends CrudService<Link, Long> {
	int deleteAllOldLinks();
}