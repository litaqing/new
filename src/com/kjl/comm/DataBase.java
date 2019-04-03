package com.kjl.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import com.kjl.utils.ConfigManager;


public class DataBase {
	private Connection conn;//数据库连接对象
	private PreparedStatement pstmt;//预处理SQL语句对象
	private ResultSet rs;//结果集对象
	
	
	//连接数据库需要的常量 
	private static String DRIVER = ConfigManager.getInstance().getValue("driver");
	private static String URL = ConfigManager.getInstance().getValue("url");
	private static String USERNAME = ConfigManager.getInstance().getValue("username");
	private static String PASSWORD = ConfigManager.getInstance().getValue("password");
	
	
	//创建连接对象
	public Connection getConn(){
		if(conn == null){
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
	
	//通过数据源获取连接对象
	/*public boolean getConn(){
		
		//使用JNDI(Java Naming and Directory Interface,Java命名和目录接口)获取连接对象
		
		try {
			//初始化上下文对象
			Context cxt = new InitialContext();
			//获取数据源   java:comp/env/数据源引用 （固定部分，java协议名称 ）  
			DataSource ds = (DataSource)cxt.lookup("java:comp/env/jdbc/magic");
			
			//获取连接对象
			conn = ds.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}*/
	
	//查询的公共方法    insert into user(uname,upass,sex,telephone,love,province) values(?,?,?,?,?,?)
	public ResultSet query(String sql,Object... params){
		System.out.println("---sql--->"+sql+"\n--params---->"+Arrays.toString(params));
		conn = getConn();//获取数据库连接
		if(conn != null){
			try {
				//预处理SQL语句的对象
				pstmt = conn.prepareStatement(sql);
				//设置SQL语句的字段值，给占位符？赋值
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject((i+1), params[i]);
				}
				//执行查询的操作
				rs = pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return rs;
	}
	
	
	//公共的删除修改增加的方法
	public int update(String sql,Object... params){
		System.out.println("---sql--->"+sql+"\n--params---->"+Arrays.toString(params));
		int row = 0;
		conn = getConn();//获取数据库连接
		if(conn != null){
			try {
				pstmt = conn.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject((1+i), params[i]);
				}
				//执行更新操作
				row = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//closeAll(rs, pstmt, conn);
			}
		}
		System.out.println("row.............."+row);
		return row;
	}
	
	//公共释放资源
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
			if(rs != null){
				rs.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
