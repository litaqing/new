package com.kjl.dao;

import java.util.List;

import com.kjl.entity.News_category;
import com.kjl.entity.News_detail;
import com.kjl.utils.PageBeanSQL;

public interface News_detailDao {
	
	//查
	public PageBeanSQL<News_detail> getPagesByListNews(String curpage,String title,String cid) throws Exception;
	//增
	public  boolean addnews (News_detail news);
	//删
	public int deleteNews(int id);
	
	//改
	public boolean updateNews(News_detail news,int id);

}
