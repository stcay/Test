package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;
import com.entity.BoardDTO;
import com.entity.PageDTO;

public class BoardPageCommand implements BoardCommand {

//boardDao의 Page를 연결
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
	
		String curPage = request.getParameter("curPage");
		if(curPage == null){	//맨 처음 요청시
			curPage = "1";
		}
		
		BoardDAO dao = new BoardDAO();
		PageDTO dto = dao.page(Integer.parseInt(curPage));
		
		request.setAttribute("page", dto);
	}
}
