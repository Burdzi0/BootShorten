package org.burdzi0.bootshorten.service;

public interface CrudService<T, ID> {
	Iterable<T> findAll();
	T findById(ID id);
	boolean exists(ID id);
	T save(T object);
	void delete(T object);
	void deleteAll();
	void deleteById(ID id);
}
