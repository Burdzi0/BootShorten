package org.burdzi0.bootshorten.controller;

import org.burdzi0.bootshorten.model.Link;
import org.burdzi0.bootshorten.service.LinkNotFoundException;
import org.burdzi0.bootshorten.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/link")
public class LinkController {

	private LinkService linkService;

	public LinkController(LinkService linkService) {
		this.linkService = linkService;
	}

	@GetMapping("/{id}")
	public @ResponseBody Link getById(@PathVariable Long id) {
		return linkService.findById(id);
	}

	@GetMapping("")
	public @ResponseBody Iterable<Link> getAll() {
		return linkService.findAll();
	}

	@PostMapping("")
	public ResponseEntity<Link> createNewLink(@RequestBody Link link) {
		link = linkService.save(link);
		return ResponseEntity.ok(link);
	}

	@GetMapping("/dummy")
	public @ResponseBody Link dummy() {
		return new Link("www.google.pl", LocalDateTime.now(), LocalDateTime.now().plusDays(10));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		linkService.deleteById(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(LinkNotFoundException.class)
	public void linkNotFound(HttpServletResponse response, LinkNotFoundException ex) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}
}
