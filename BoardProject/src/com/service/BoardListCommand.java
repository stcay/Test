package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;
import com.entity.BoardDTO;

public class BoardListCommand implements BoardCommand {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.list();
		
		// list.jsp에서 List<BoardDTO>를 보여준다.
		// 3가지 scope에 저장한다.
		
		request.setAttribute("list", list);
	}
}
