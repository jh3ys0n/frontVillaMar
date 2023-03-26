package com.malku.app.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class MediaFinder {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String subTitle;
    @Column
    private String description;
    
    @Column
    private String slug;
    
    @OneToMany(mappedBy = "mediaFinder",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE})
    @JsonManagedReference
    private List<Document> documents=new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="idHome", nullable=true,referencedColumnName = "id")
    private Home home;
    
    
    public MediaFinder() {}

	

	public MediaFinder(String title, String subTitle, String description, String slug, 
			Home home) {
		super();
		this.title = title;
		this.subTitle = subTitle;
		this.description = description;
		this.slug = slug;
		this.home = home;
	}



	public MediaFinder( String title, String subTitle, String description, String slug) {
		super();
		
		this.title = title;
		this.subTitle = subTitle;
		this.description = description;
		this.slug = slug;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getSlug() {
		return slug;
	}



	public void setSlug(String slug) {
		this.slug = slug;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}



	@Override
	public String toString() {
		return "MediaFinder [id=" + id + ", title=" + title + ", subTitle=" + subTitle + ", description=" + description
				+ ", slug=" + slug + ", documents=" + documents + ", home=" + home + "]";
	}



	public void insertDocument(Document document) {
		System.out.println("entra al insert......--------------------->");
		documents.add(document);
	}
    
    
}
