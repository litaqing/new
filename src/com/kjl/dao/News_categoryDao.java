package com.kjl.dao;

import com.kjl.entity.News_category;
import com.kjl.entity.News_user;
import com.kjl.utils.PageBeanSQL;

public interface News_categoryDao {
	public News_category findcategory(int id);
	//添加的方法
	public boolean add(News_category cate) throws Exception;
	//SQL分页的方法
	public PageBeanSQL<News_category> listPageSQL(String curPage) throws Exception;

	//删除
	public int deleteUsercate(int id);
			
	//修改
	public boolean updateUsercate(int id,String name, String createdate);
			
			

}
