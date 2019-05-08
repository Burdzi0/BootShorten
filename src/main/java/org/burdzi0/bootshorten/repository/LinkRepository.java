package org.burdzi0.bootshorten.repository;

import org.burdzi0.bootshorten.model.Link;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<Link, Long>{
	@Query("DELETE FROM Link l WHERE l.expiration < CURRENT_TIMESTAMP")
	int removeOldLinks();
}
