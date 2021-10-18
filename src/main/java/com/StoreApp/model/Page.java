package com.StoreApp.model;

public class Page {
	private Integer limitOfPage;
	private Integer page;
	private Integer rows;
	public Page() {
	}
	@Override
	public String toString() {
		return "{limitOfPage:" + limitOfPage + ", page:" + page+ ", rows:" + rows + "}";
	}
	public Integer getLimitOfPage() {
		return limitOfPage;
	}
	public void setLimitOfPage(Integer limitOfPage) {
		this.limitOfPage = limitOfPage;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getRows() {
		return rows;
	}
	public Page(Integer limitOfPage, Integer page, Integer rows) {
		super();
		this.limitOfPage = limitOfPage;
		this.page = page;
		this.rows = rows;
	}
	
}
