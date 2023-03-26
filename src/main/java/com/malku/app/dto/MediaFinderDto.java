package com.malku.app.dto;

public class MediaFinderDto {

	private String title;
	private String subTitle;
	private byte[] content;
	private String base64;
	
	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public MediaFinderDto(String title, String subTitle, byte[] content, String base64) {
		super();
		this.title = title;
		this.subTitle = subTitle;
		this.content = content;
		this.base64 = base64;
	}

	public MediaFinderDto() {
		super();
	}
	
	public MediaFinderDto(String title, String subTitle, byte[] content) {
		super();
		this.title = title;
		this.subTitle = subTitle;
		this.content = content;
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

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	
}
