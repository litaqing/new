package com.kjl.entity;

import java.util.Date;

public class News_detail {
	
	private  int id;
	private  int categoryid;
	private  String title;
	private  String summary;
	private  String content;
	private  String picpath;
	private  String author;
	private  Date createdate;
	private  Date modifydate;
	private  News_category cate;
	
	
	
	public News_category getCate() {
		return cate;
	}




	public void setCate(News_category cate) {
		this.cate = cate;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getCategoryid() {
		return categoryid;
	}




	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getSummary() {
		return summary;
	}




	public void setSummary(String summary) {
		this.summary = summary;
	}




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public String getPicpath() {
		return picpath;
	}




	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}




	public String getAuthor() {
		return author;
	}




	public void setAuthor(String author) {
		this.author = author;
	}




	public Date getCreatedate() {
		return createdate;
	}




	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}




	public Date getModifydate() {
		return modifydate;
	}




	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}






	public News_detail(int id, int categoryid, String title, String summary,
			String content, String picpath, String author, Date createdate,
			Date modifydate, News_category cate) {
		super();
		this.id = id;
		this.categoryid = categoryid;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.picpath = picpath;
		this.author = author;
		this.createdate = createdate;
		this.modifydate = modifydate;
		this.cate = cate;
	}






	public News_detail(int categoryid, String title, String summary,
			String content, String picpath, String author, Date createdate,
			Date modifydate) {
		super();
		this.categoryid = categoryid;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.picpath = picpath;
		this.author = author;
		this.createdate = createdate;
		this.modifydate = modifydate;
	}




	public News_detail() {
		super();
	}




	@Override
	public String toString() {
		return "News_detail [id=" + id + ", categoryid=" + categoryid
				+ ", title=" + title + ", summary=" + summary + ", content="
				+ content + ", picpath=" + picpath + ", author=" + author
				+ ", createdate=" + createdate + ", modifydate=" + modifydate
				+ ", cate=" + cate + "]";
	}





	

	
	
	
	
}
