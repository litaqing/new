package com.kjl.dao.impl;

import com.kjl.comm.DataBase;
import com.kjl.dao.News_categoryDao;
import com.kjl.entity.News_category;
import com.kjl.utils.PageBeanSQL;

public class News_categoryDaoimpl extends DataBase implements News_categoryDao {

	public News_category findcategory(int id) {
		
		
		return null;
	}

	public boolean add(News_category cate) throws Exception {
		String sql ="insert into news_category(name,createname) values(?,?)";
		Object []params = {cate.getName(),cate.getCreatedate()};
		return update(sql, params)>0;
	}

	public PageBeanSQL<News_category> listPageSQL(String curPage)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteUsercate(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from news_category where id="+id;
		return super.update(sql);
	}

	public boolean updateUsercate(int id, String name, String createdate) {
		// TODO Auto-generated method stub
	
			String sql = "update news_category set name=?,createdata=? where sid="+id;
			Object[] params={name,createdate};
			
			int row = update(sql,params);
			
			return row > 0;
	}

}
