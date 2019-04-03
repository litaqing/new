package com.kjl.service.impl;

import java.util.List;



import com.kjl.dao.News_userDao;
import com.kjl.dao.impl.News_userDaoimpl;
import com.kjl.entity.News_user;
import com.kjl.service.Newservice;
import com.kjl.utils.PageBeanSQL;

public  class Newserviceimpl implements Newservice{
	//	private ProductDao productDao = new ProductDaoImpl();
	
	//注入Dao层
    private News_userDao newuser = new News_userDaoimpl();
    

	public PageBeanSQL<News_user> listPageSQL(String curPage) throws Exception {
		
		return newuser.listPageSQL(curPage);
	}

}
