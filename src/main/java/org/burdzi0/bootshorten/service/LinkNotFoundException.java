package org.burdzi0.bootshorten.service;

public class LinkNotFoundException extends RuntimeException {

	public LinkNotFoundException(String msg) {
		super(msg);
	}
}
