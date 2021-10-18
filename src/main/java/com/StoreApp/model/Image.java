package com.StoreApp.model;

public class Image {
	private Integer idInteger;
	private String link;
	
	public Image() {
		
	}

	public Image(Integer idInteger, String link) {
		this.idInteger = idInteger;
		this.link = link;
	}

	public Integer getIdInteger() {
		return idInteger;
	}

	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Image [idInteger=" + idInteger + ", link=" + link + "]";
	}
	
}
