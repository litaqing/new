package com.kjl.service;

import java.util.List;

import com.kjl.entity.News_user;
import com.kjl.utils.PageBeanSQL;


public interface Newservice {
	//分页SQL的方法
    public PageBeanSQL<News_user> listPageSQL(String curPage) throws Exception;

}
