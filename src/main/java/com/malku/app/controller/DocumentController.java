package com.malku.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.malku.app.persistence.entity.Document;
import com.malku.app.service.DocumentService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 6000)
@RestController
@RequestMapping("/api/document/")
public class DocumentController {

	@Autowired
	private DocumentService documentService;
	
	@PostMapping("/")
	public ResponseEntity<Document> uploadDocument(@RequestParam("document")MultipartFile file) {
		
		return ResponseEntity.ok( documentService.save(file));	
		
		
	}
}
