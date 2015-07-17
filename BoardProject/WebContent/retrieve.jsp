<%@page import="com.entity.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>



<body>

<form action="update" method="post">
<input type='hidden' name='num' value="${requestScope.retrieve.num }">
글번호 :${retrieve.num }&nbsp;&nbsp;작성일: ${retrieve.writeday }&nbsp;&nbsp;
조회수 : ${retrieve.readcnt }
제목 <input type="text" name="title" value="${retrieve.title }"><br>
작성자 <input type="text" name="author" value="${retrieve.author }"><br>
내용<br> <textarea rows="10" cols="10" name="content">${retrieve.content }</textarea>

<br>
<input type="submit" value="글수정">
<a href="delete?num=${retrieve.num }">글삭제</a>
</form>

</body>
</html>