package org.burdzi0.bootshorten.repository;

import org.burdzi0.bootshorten.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LinkRepository extends JpaRepository<Link, Long> {
	@Query("DELETE FROM Link l WHERE l.expiration < CURRENT_TIMESTAMP")
	int removeOldLinks();
}
