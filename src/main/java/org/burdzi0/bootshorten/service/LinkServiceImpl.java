package org.burdzi0.bootshorten.service;

import org.burdzi0.bootshorten.model.Link;
import org.burdzi0.bootshorten.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class LinkServiceImpl implements LinkService{

	private LinkRepository repository;

	public LinkServiceImpl(LinkRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<Link> findAll() {
		Collection<Link> all = new ArrayList<>();
		repository.findAll().forEach(all::add);
		return all;
	}

	@Override
	public Link findById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new LinkNotFoundException("Link with id:" + id + " does not exist")
		);
	}

	@Override
	public boolean exists(Long id) {
		return repository.existsById(id);
	}

	@Override
	public Link save(Link link) {
		link.setSince(LocalDateTime.now());
		return repository.save(link);
	}

	@Override
	public void delete(Link link) {
		repository.delete(link);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public int deleteAllOldLinks() {
		return repository.removeOldLinks();
	}
}
