<%@page import="com.entity.PageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PageDTO xxx = (PageDTO) request.getAttribute("page");
	int curPage = xxx.getCurPage();
	int totalCount = xxx.getTotalCount();
	int purPage = xxx.getPerPage();

	int totalNum = totalCount / curPage;
	if (totalCount % curPage != 0)
		totalNum++;

	for (int i = 1; i <= totalNum; i++) {
		if(curPage == i){
			out.print(i+"&nbsp;");
		}else{
			out.print("<a href='/BoardProject/controller/page?curPage="+i+"'>"+i+"</a>&nbsp;");
		}
	}//end for
%>