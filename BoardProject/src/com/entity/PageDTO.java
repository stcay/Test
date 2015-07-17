package com.entity;

import java.util.List;

public class PageDTO {

	private int perPage = 3;	//페이지당 보여줄 갯수
	private int curPage;
	private int totalCount; 	//전체 레코드 갯수
	private List<BoardDTO> list;
	
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<BoardDTO> getList() {
		return list;
	}
	public void setList(List<BoardDTO> list) {
		this.list = list;
	}
	
}
