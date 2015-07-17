<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
</head>
<body>
<form action="controller/write" method="post">
제목 : <input type="text" name="title"><br>
작성자 : <input type="text" name="author"><br>
내용 <Br> <textarea rows="10" cols="20" name="content"></textarea>
<br>
<input type="submit" value="글쓰기">

</form>
</body>
</html>