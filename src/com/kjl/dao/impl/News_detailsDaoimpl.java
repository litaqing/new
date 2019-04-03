package com.kjl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.kjl.comm.DataBase;
import com.kjl.dao.News_detailDao;
import com.kjl.entity.News_category;
import com.kjl.entity.News_detail;
import com.kjl.entity.News_user;
import com.kjl.utils.PageBeanSQL;

public class News_detailsDaoimpl extends DataBase implements News_detailDao {
	//查询

	public PageBeanSQL<News_detail> getPagesByListNews(String curpage,
			String title, String cid) throws Exception {
		String sql = "select d.*,c.name as cname,c.id as cid from news_detail d,news_category c where 1=1 " ;
		if(title != null &&!"".equals(title) ){
			sql+="and d.title like '%"+title+"%'" ;
			
		}
		if(cid!=null&&!"0".equals(cid)){
			sql+="and c.id = "+cid+" ";
			
		}
		sql+=" and d.categoryId = c.id order by d.id limit ?,?";
		System.out.println("....///..."+sql);
        PageBeanSQL<News_detail> pages =new PageBeanSQL<News_detail>();
        
        pages.setRowCount(getRowCount(title));
        
        int pageno =0;
        pageno = Integer.parseInt(curpage);
        if(pageno<=0){
        	pages.setCurPageNo(1);
        	
        }else if (pageno>pages.getPageCount()){
        	pages.setCurPageNo(pages.getPageCount());
        	
        	
        }else{
        	
        	pages.setCurPageNo(pageno);
        }
        
        int startrow = ((pages.getCurPageNo()-1)*pages.getPageSize());
        int endrow = pages.getPageSize();
        
        ResultSet rs = query(sql, startrow,endrow);
        
        
        
        List<News_detail> list = new ArrayList<News_detail>();
        
        News_detail news = null;
        News_category cate = null;
        while (rs.next()){
        	news = new News_detail();
        	news.setAuthor(rs.getString("author"));
			news.setCategoryid(rs.getInt("categoryid"));
			news.setContent(rs.getString("content"));
			news.setCreatedate(rs.getDate("createdate"));
			news.setId(rs.getInt("id"));
			news.setModifydate(rs.getDate("modifydate"));
			news.setPicpath(rs.getString("picpath"));
			news.setSummary(rs.getString("summary"));
			news.setTitle(rs.getString("title"));
        	
			cate = new News_category();
			cate.setId(Integer.parseInt(rs.getString("cid")));
			cate.setName(rs.getString("cname"));
			news.setCate(cate);
			 
			list.add(news);
			
			/*ct = new Category();
			ct.setId(Integer.parseInt(rs.getString("cid")));
			ct.setName(rs.getString("categoryName"));
			
			news.setCategory(ct);
			
			list.add(news);*/
			
        	
        }
        pages.setPageList(list);
		return pages;
	}
	private int getRowCount(String title) throws SQLException{
		int row = 0;
		String sql = "select count(*) from news_detail";
		if(title != null){
			sql += " where  title like '%"+title+"%'";
		}
		ResultSet rs = query(sql);
		while (rs.next()) {
			row = rs.getInt(1);
		}
		return row;
	}

	//增加
	
/*	public boolean addUser(User user){
		//?占位符
		String sql = "insert into user(uname,upass,sex,telephone,love,province) values(?,?,?,?,?,?)";
		Object[] params = {user.getUname(),user.getUpass(),user.getSex(),user.getTelephone(),user.getLove(),user.getProvince()};
		return update(sql, params) > 0;*/
	
	public  boolean addnews (News_detail news){
		String sql = "insert into news_detail (categoryId,title,summary,content,picpath,author,createdate,modifydate) values(?,?,?,?,?,?,?,?)";
		Object [] params ={news.getCategoryid(),news.getTitle(),news.getSummary(),news.getContent(),news.getPicpath(),news.getAuthor(),news.getCreatedate(),news.getModifydate()};
		
		
		return update(sql, params) > 0;
		
		
		
	}
	//删除
	public int deleteNews(int id) {
		String sql ="delete from news_detail where id = ? ";
		Object [] params = {id};
		
		return update(sql, params);
	}
	//修改
	public boolean updateNews(News_detail news,int id ) {
		String sql = "update news_detail set categoryId = ?, title = ?, summary = ?,content = ? ,picpath = ?,author = ?, createdate = ?,modifydate = ? where id = ? ";
		Object [] params ={news.getCategoryid(),news.getTitle(),news.getSummary(),news.getContent(),news.getPicpath(),news.getAuthor(),news.getCreatedate(),news.getModifydate(),id};
		
		return update(sql, params)>0;
	}
}
