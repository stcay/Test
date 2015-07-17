package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;
import com.entity.BoardDTO;

public class BoardUpdateCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		String num = request.getParameter("num");
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO dto = new BoardDTO();
		dto.setNum(Integer.parseInt(num));
		dto.setAuthor(author);
		dto.setTitle(title);
		dto.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		int n = dao.update(dto);
		
		request.setAttribute("update", dto);
		
	}
}
