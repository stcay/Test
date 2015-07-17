
<%@page import="com.entity.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록보기</title>
</head>
<body>
	
	<table border="1">
		<!-- 검색 -->
		<tr>
			<td colspan="5">
			<form action="search" method="get">
			<select name="searchName">
					<option value="title">제목</option>
					<option value="author">작성자</option>
			</select>
			<input type="text" name="searchValue">
			<input type="submit" value="검색">
			</form>
			</td>
		</tr>
		<!-- 검색 -->
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		
		<%
			ArrayList<BoardDTO> list = (ArrayList<BoardDTO>) request.getAttribute("list");
			for (BoardDTO dto : list) {
				int num = dto.getNum();
				String author = dto.getAuthor();
				String title = dto.getTitle();
				String writeday = dto.getWriteday();
				int readcnt = dto.getReadcnt();
		%>
		<tr>
			<td><%=num%></td>
			<td><%=author%></td>
			<td><a href="retrieve?num=<%=num%>"> <%=title%></a></td>
			<td><%=writeday%></td>
			<td><%=readcnt%></td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="writeui">글쓰기</a>
</body>
</html>