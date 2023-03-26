package com.malku.app.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private long size;
	@Column(columnDefinition = "longblob")
	private byte[] content;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade ={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE})
	@JsonBackReference
	@JoinColumn(referencedColumnName = "id")
    private MediaFinder mediaFinder;
	
	public Document(String name, long size, byte[] content) {
		super();
		this.name = name;
		this.size = size;
		this.content = content;
	}

	
	public MediaFinder getMediaFinder() {
		return mediaFinder;
	}


	public void setMediaFinder(MediaFinder mediaFinder) {
		this.mediaFinder = mediaFinder;
	}


	public Document() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	 
	
	
}
