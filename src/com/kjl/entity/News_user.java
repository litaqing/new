package com.kjl.entity;

public class News_user {
	/* id                INT(10)    PRIMARY KEY AUTO_INCREMENT,  ---用户编号
	  username          VARCHAR(20)     NOT NULL,            ---用户名  
	  PASSWORD          VARCHAR(20)    NOT NULL,             ---密码
	  email             VARCHAR(100)   NULL,
	  usertype          INT(5)     NOT NULL               ----用户类型  0：管理员 1：普通用户*/
	private  int id;
	private String username;
	private String password;
	private String email;
	private int usertype;
	private News_category cate;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	
	//全部参数
	public News_user(int id, String username, String password, String email,
			int usertype) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	//除id外的所有参数
	public News_user( String username, String password, String email,
			int usertype) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.usertype = usertype;
	}
	
	//无参构造
	public News_user() {
		super();
	}
	
	
	

}
