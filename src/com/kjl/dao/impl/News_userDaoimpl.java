package com.kjl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import com.kjl.comm.DataBase;
import com.kjl.dao.News_userDao;
import com.kjl.entity.News_user;
import com.kjl.utils.PageBeanSQL;

public class News_userDaoimpl extends DataBase implements News_userDao {

	public News_user findByUser(String loginName, String pwd) {
		
		String sql = "select * from news_user where username=? and password=?";
		Object[] params = {loginName,pwd};//
	   	ResultSet rs = super.query(sql,params);
		News_user user = null;
	   	
		try {
			while(rs.next()){
				user = new News_user();//创建用户对象
				String uid = rs.getString("id");
				String name = rs.getString("username");//数据库中字段
				String pwds = rs.getString("password");
				String email = rs.getString("email");
				String usertype = rs.getString("usertype");

				//赋给对象
				user.setId(Integer.parseInt(uid));
				user.setUsername(name);
				user.setPassword(pwds);
				user.setEmail(email);
				user.setUsertype(Integer.parseInt(usertype));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(rs, null, null);
		}
		return user;
	}
	
	
/*	//添加
	public boolean addUser(News_user user){
		//?占位符
		String sql = "insert into user(uname,upass,sex,telephone,love,province) values(?,?,?,?,?,?)";
		Object[] params = {user.getUname(),user.getUpass(),user.getSex(),user.getTelephone(),user.getLove(),user.getProvince()};
		return update(sql, params) > 0;
	}*/
	
	//获取总记录数的方法
		private int getRowCount() throws SQLException{
			int row = 0;
			String sql = "select count(*) from news_user";		
			ResultSet rs = query(sql);
			while (rs.next()) {
				row = rs.getInt(1);
			}
			return row;
		}


	public boolean add(News_user user) throws Exception {
		
		String sql ="insert into news_user(username,password,email,usertype) values(?,?,?,?)";
		Object []params = {user.getUsername(),user.getPassword(),user.getEmail(),user.getUsertype()};
		return update(sql, params)>0;
	}

     //SQL分页
	
/*public PageBeanSQL<Product> listPageSQL(String curPage) throws Exception {
		
		String sql = "select * from product order by pid limit ?,? ";//SQL模板
		
		PageBeanSQL<Product> pages = new PageBeanSQL<Product>();
		
		//pages.setPageSize(5);//设置页大小
		//获取总记录数
		pages.setRowCount(getRowCount());//总页数
		
		//当前页
		int pageNo = Integer.parseInt(curPage);
		
		//当前页小于等于0
		if(pageNo <= 0){
			pages.setCurPageNo(1);
		}else if(pageNo >= pages.getPageCount()){//当前页大于总页数
			pages.setCurPageNo(pages.getPageCount());
		}else{
			pages.setCurPageNo(pageNo);
		}
		//计算起始结束位置
		int startRow = ((pages.getCurPageNo()-1) * pages.getPageSize());
		int endRow = pages.getPageSize();
		
		
		ResultSet rs = query(sql, startRow,endRow);
		
		List<Product> list = getProduct(rs);
		
		pages.setPageList(list);
		return pages;
	}*/
	
	
	public PageBeanSQL<News_user> listPageSQL(String curPage) throws Exception {
		String sql = "select * from news_user order by id limit ?,?";
		PageBeanSQL<News_user> pages = new PageBeanSQL<News_user>();
		pages.setRowCount(getRowCount());
		int pageNo = Integer.parseInt(curPage);
		if(pageNo <= 0){
			pages.setCurPageNo(1);
		}else if(pageNo >= pages.getPageCount()){//当前页大于总页数
			pages.setCurPageNo(pages.getPageCount());
		}else{
			pages.setCurPageNo(pageNo);
		}
		
		int startRow = ((pages.getCurPageNo()-1) * pages.getPageSize());
		int endRow = pages.getPageSize();
		
		
		ResultSet rs = query(sql, startRow,endRow);
		
		List<News_user> list = getProduct(rs);
		
		pages.setPageList(list);
		return pages;
	}
	
	
	public List<News_user> getProduct(ResultSet rs) throws SQLException{
		List<News_user> list = new ArrayList<News_user>();
		News_user news = null;
		while(rs.next()){
			//创建商品对象
			news = new News_user();
			
			/*news.setPid(rs.getInt("pid"));
			news.setPname(rs.getString("pname"));
			news.setPrice(rs.getFloat("price"));
			news.setContent(rs.getString("content"));
			news.setAddTime(rs.getDate("addTimes"));
			news.setAttfile(rs.getString("attfile"));
			news.setFilename(rs.getString("filename"));*/
			//封装进行添加到集合
			
			news.setId(rs.getInt("id"));
			news.setUsername(rs.getString("username"));
			news.setPassword(rs.getString("password"));
			news.setEmail(rs.getString("email"));
			news.setUsertype(rs.getInt("usertype"));
			list.add(news);
		}
		return list;
	}


	public int deleteUser(int id) {
		String sql = "delete from news_user where id="+id;
		return super.update(sql);	
	}
	//删除
		/*public int deleteUser(int id){
			String sql = "delete from user where sid="+id;
			return super.update(sql);
		}
		
		//修改
		public boolean updateUser(int id,String uname, String upass, String sex,
				String telephone, String love, String province){
			
			String sql = "update user set uname=?,upass=?,sex=?,telephone=?,love=?,province=?  where sid="+id;
			Object[] params={uname,upass,sex,telephone,love,province};
			
			int row = update(sql,province);
			
			return row > 0;
			
		}
		*/

	public boolean updateUser(int id, String uname, String upass, String email,
			int usertype) {
		String sql = "update news_user set username=?,password=?,email=?,usertype=?  where sid="+id;
		Object[] params={uname,upass,email,usertype};
		
		int row = update(sql,params);
		
		return row > 0;
	}


}
