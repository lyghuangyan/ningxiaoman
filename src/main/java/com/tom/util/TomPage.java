package com.tom.util;

import java.io.Serializable;

import com.github.pagehelper.Page;

public class TomPage implements Serializable{
	public TomPage() {
		super();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -2907976852967120658L;
	private Object page;
	private Integer pages;
	private Long total;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public TomPage(Page page) {
		this.page = page;
		this.pages = page.getPages();
		this.total = page.getTotal();
	}
	public TomPage(Page page, Object data) {
		this.page = data;
		this.pages = page.getPages();
		this.total = page.getTotal();
	}
	public Object getPage() {
		return page;
	}
	public void setPage(Object page) {
		this.page = page;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
}
