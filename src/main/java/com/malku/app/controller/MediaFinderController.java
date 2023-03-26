package com.malku.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.malku.app.dto.MediaFinderDto;
import com.malku.app.persistence.entity.Document;
import com.malku.app.persistence.entity.MediaFinder;
import com.malku.app.persistence.entity.User;
import com.malku.app.service.MediaFinderService;

import jakarta.annotation.security.PermitAll;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 6000)
@RestController
@RequestMapping("/api/mediaFinder/")
public class MediaFinderController {

	@Autowired
	private MediaFinderService mediaFinderService;
	
	@PermitAll
    @GetMapping
    public String findAll() {
        return "index";
    }
	
	@PutMapping("/")
	public ResponseEntity<MediaFinder> uploadDocument(@RequestParam("document")MultipartFile document,@RequestParam("title")String title,@RequestParam("subTitle")String subTitle,@RequestParam("slug")String slug) throws IOException {
		
		return ResponseEntity.ok( mediaFinderService.save(document,title,subTitle,slug));	
		
		
	}
	
	@PermitAll
    @GetMapping("portadas/{portada}")
    public ResponseEntity<byte[]> getPortadas(@PathVariable (value = "portada") String portada) {
		byte[] portadas =  mediaFinderService.getPortadas(portada);
        return ResponseEntity.ok(portadas);
    }
    
    @PermitAll
    @GetMapping("portadas/images")
    public ResponseEntity<List<byte[]>[]> getPortadasImages() {
    	List<byte[]>[] portadas =  mediaFinderService.getPortadasImages();
        return ResponseEntity.ok(portadas);
    }
    
    
    @PermitAll
    @GetMapping("portadas/get/{portada}")
    public ResponseEntity<MediaFinderDto> getPortadasHome(@PathVariable (value = "portada") String portada) {
    	MediaFinderDto portadas =  mediaFinderService.getPortadasHome(portada);
        return ResponseEntity.ok(portadas);
    }
    
    @PermitAll
    @GetMapping("portadas/get/")
    public ResponseEntity<List<MediaFinderDto>> getPortada() {
    	List<MediaFinderDto> lista=new ArrayList<>();
    	MediaFinderDto portadas =  mediaFinderService.getPortadasHome("portada-1");
    	lista.add(portadas);
    	 portadas =  mediaFinderService.getPortadasHome("portada-2");
    	 lista.add(portadas);
    	 portadas =  mediaFinderService.getPortadasHome("portada-3");
      	 lista.add(portadas);
        return ResponseEntity.ok(lista);
    }
}
