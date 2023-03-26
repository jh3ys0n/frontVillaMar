package com.malku.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.malku.app.dto.MediaFinderDto;
import com.malku.app.persistence.entity.Document;
import com.malku.app.persistence.entity.MediaFinder;
import com.malku.app.persistence.repository.MediaFinderRepository;

@Service
public class MediaFinderService {

	@Autowired
	private MediaFinderRepository mediaFinderRepository;
	private ModelMapper modelMapper;
	private DocumentService documentService;
	
	public MediaFinderService(MediaFinderRepository mediaFinderRepository, ModelMapper modelMapper,
			DocumentService documentService) {
		super();
		this.mediaFinderRepository = mediaFinderRepository;
		this.modelMapper = modelMapper;
		this.documentService = documentService;
	}

	public MediaFinder save(MultipartFile file, String title, String subTitle,String slug) throws IOException {
			
		MediaFinder mediaFinder= mediaFinderRepository.findBySlug(slug);	
		
		if(mediaFinder==null) {
			Document document=documentService.save(file);
			System.out.println(document.toString());
			
			 mediaFinder=mediaFinderRepository.save(new MediaFinder(title,subTitle,"",slug));	
			
			mediaFinder.insertDocument(document);
			document.setMediaFinder(mediaFinder);
			return mediaFinderRepository.save(mediaFinder);
			//return null;
		}
		else {
			mediaFinderRepository.delete(mediaFinder);
		//	document.setMediaFinder(mediaFinder);
			Document document=documentService.save(file);
			System.out.println(document.toString());
			
			 mediaFinder=mediaFinderRepository.save(new MediaFinder(title,subTitle,"",slug));	
			
			mediaFinder.insertDocument(document);
			document.setMediaFinder(mediaFinder);
			return mediaFinderRepository.save(mediaFinder);
		}
		
		
	}

	public byte[] getPortadas(String portada) {
		MediaFinder portada1=(MediaFinder) mediaFinderRepository.findBySlug(portada);
		
		
		return portada1.getDocuments().get(0).getContent();
	}

	public MediaFinderDto getPortadasHome(String portadas) {
		MediaFinder portada1=(MediaFinder) mediaFinderRepository.findBySlug(portadas);
		MediaFinderDto portada=new MediaFinderDto();
		portada.setTitle(portada1.getTitle());
		portada.setSubTitle(portada1.getSubTitle());
		portada.setBase64(documentService.convertToBase64( portada1.getDocuments().get(0).getContent()));
		return portada;
	}

	public List<byte[]>[]  getPortadasImages() {
		List<byte[]>[] myArray = new ArrayList[2];
		MediaFinder portada1=(MediaFinder) mediaFinderRepository.findBySlug("portada-1");
		myArray[0].add(portada1.getDocuments().get(0).getContent());
		portada1=(MediaFinder) mediaFinderRepository.findBySlug("portada-2");
		myArray[0].add(portada1.getDocuments().get(0).getContent());
		portada1=(MediaFinder) mediaFinderRepository.findBySlug("portada-3");
		myArray[0].add(portada1.getDocuments().get(0).getContent());
		return myArray;
	}
	
	
	
	
}
