package com.kjl.utils;

import java.util.ArrayList;
import java.util.List;

public class PageBeanSQL<T> {
	
	private int rowCount;//总记录数
	private int pageSize = 8;//每页显条数
	private int pageCount;//总页数
	private int curPageNo = 1;//当前页
	
	private List<T> pageList = new ArrayList<T>();//存放当前页的要显示的所有记录
	
	//设置总页数
	public void setPageCountByPage(){
		if(rowCount % pageSize == 0 ){
			pageCount = rowCount / pageSize;
		}else if(rowCount % pageSize > 0){
			pageCount = rowCount / pageSize + 1;
		}
	}
	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		if(rowCount > 0){
			this.rowCount = rowCount;
			setPageCountByPage();
		}
	}
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurPageNo() {
		return curPageNo;
	}

	public void setCurPageNo(int curPageNo) {
		this.curPageNo = curPageNo;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	
	
}
