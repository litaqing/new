package com.kjl.entity;

import java.util.Date;
import java.util.List;

public class News_category {
	private int id;
	private String name;
	private Date createdate;
	private List<News_detail> news;
	
	
	
	public List<News_detail> getNews() {
		return news;
	}
	public void setNews(List<News_detail> news) {
		this.news = news;
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
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	
	
	public News_category() {
		super();
	}
	public News_category(int id, String name, Date createdate,
			List<News_detail> news) {
		super();
		this.id = id;
		this.name = name;
		this.createdate = createdate;
		this.news = news;
	}
	@Override
	public String toString() {
		return "News_category [id=" + id + ", name=" + name + ", createdate="
				+ createdate + ", news=" + news + "]";
	}
	

	
	

}
