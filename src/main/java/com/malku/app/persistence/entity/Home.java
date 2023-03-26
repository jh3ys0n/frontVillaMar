package com.malku.app.persistence.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Home {
	
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int id;
	
	@Column
    private String title;
    @Column
    private String subTitle;
	
	@OneToMany(mappedBy = "home",cascade =CascadeType.ALL,orphanRemoval = true)
	private List<MediaFinder> media;

	public Home() {}
	public Home(String title, String subTitle, List<MediaFinder> media) {
		super();
		this.title = title;
		this.subTitle = subTitle;
		this.media = media;
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
	public List<MediaFinder> getMedia() {
		return media;
	}
	public void setMedia(List<MediaFinder> media) {
		this.media = media;
	}
	
	
}
