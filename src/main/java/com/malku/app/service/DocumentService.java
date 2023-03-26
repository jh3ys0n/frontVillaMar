package com.malku.app.service;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.malku.app.persistence.entity.Document;
import com.malku.app.persistence.repository.DocumentRepository;
import java.util.Base64;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	private ModelMapper modelMapper;
	
	
	
	public DocumentService(DocumentRepository documentRepository, ModelMapper modelMapper) {
		super();
		this.documentRepository = documentRepository;
		this.modelMapper = modelMapper;
	}



	public Document save(MultipartFile file) {
		Document documentQuotation= new Document();
		try {
			String nameFile=file.getOriginalFilename();
			documentQuotation.setName(nameFile);
			documentQuotation.setContent(file.getBytes());
			documentQuotation.setSize(file.getSize());
			
			documentRepository.save(documentQuotation);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return documentQuotation;
	}
	
	public Document createDocument(MultipartFile file) {
		Document documentQuotation= new Document();
		try {
			String nameFile=file.getOriginalFilename();
			documentQuotation.setName(nameFile);
			documentQuotation.setContent(file.getBytes());
			documentQuotation.setSize(file.getSize());
			
			//documentRepository.save(documentQuotation);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return documentQuotation;
	}
	
	public void deleteDocument(Document id) {
		System.out.print("-----sdfsdfsdfasdasdasdasdasdas------");
		documentRepository.delete(id);
	}
	public void update(MultipartFile file,int id) throws IOException {
		Document document=	documentRepository.findById(id).get();
		document.setName(file.getOriginalFilename());
		document.setContent(file.getBytes());
		document.setSize(file.getSize());
		
		 documentRepository.save(document);
	}
	
	public String convertToBase64(byte[] bytes) {
	    String base64 = Base64.getEncoder().encodeToString(bytes);
	    return "data:image/png;base64,"+base64;
	}
}
