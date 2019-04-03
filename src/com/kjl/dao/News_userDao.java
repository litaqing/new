package com.kjl.dao;




import com.kjl.entity.News_user;
import com.kjl.utils.PageBeanSQL;


public interface News_userDao {
	
	//通过用户名，密码登录的方法
	public News_user findByUser(String loginName,String pwd);
   //添加的方法
	public boolean add(News_user user) throws Exception;
	//SQL分页的方法
	public PageBeanSQL<News_user> listPageSQL(String curPage) throws Exception;

	//删除
		public int deleteUser(int id);
		
		//修改
		public boolean updateUser(int id,String uname, String upass, String email,
				int  usertype);
		
		

}
