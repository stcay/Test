package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.BoardDeleteCommand;
import com.service.BoardListCommand;
import com.service.BoardPageCommand;
import com.service.BoardRetrieveCommand;
import com.service.BoardSearchCommand;
import com.service.BoardUpdateCommand;
import com.service.BoardWriteCommand;

@WebServlet("/controller/*")
public class BoardFrontController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		int a;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
//		System.out.println("requestURI >> " + requestURI);
		
		String requestcontextPath = request.getContextPath();
//		System.out.println("requestcontextPath >> " +requestcontextPath);
		
		String servletPath = request.getServletPath();
//		System.out.println("servletPath >> " +servletPath);
		
		String contextPath = request.getContextPath();
//		System.out.println(contextPath);
		
		String com = requestURI.substring(contextPath.length());
//		System.out.println(com);
		
		String action = com.substring(servletPath.length()); // /list
//		System.out.println(action);
		
		// 1.목록보기 http://localhost:8090/BoardProject/controller?action=list
		//			 http://localhost:8090/BoardProject/controller/list
		
		if("/list".equals(action.trim())){ 
			BoardListCommand command = new BoardListCommand();
			command.execute(request, response);
			
			//response.sendRedirect("/list.jsp");
			
			//http://localhost:8090/context/list.jsp (기본 컨텍스트 명까지)
			RequestDispatcher dis = request.getRequestDispatcher("/list.jsp");
			dis.forward(request, response);
		}
		
		
		if("/page".equals(action.trim())){ 
			BoardPageCommand command = new BoardPageCommand();
			command.execute(request, response);
			
			//response.sendRedirect("/list.jsp");
			
			//http://localhost:8090/context/list.jsp (기본 컨텍스트 명까지)
			RequestDispatcher dis = request.getRequestDispatcher("/listPage.jsp");
			dis.forward(request, response);
		}
		
		// 2. 글쓰기 http://localhost:8090/BoardProject/controller?action=write
		//			 http://localhost:8090/BoardProject/controller/write
		
		if("/writeui".equals(action)){ 
			//http://localhost:8090/list.jsp (8090까지니까 ../를 붙여서 컨텍스트 명(프로젝트명)을 찾아가야함)
			response.sendRedirect("../writeui.jsp");
		}
		
		if("/write".equals(action.trim())){ 
			BoardWriteCommand command = new BoardWriteCommand();
			command.execute(request, response);
			
			response.sendRedirect("/BoardProject/controller/list");
		}
		if("/retrieve".equals(action.trim())){ 
			BoardRetrieveCommand command = new BoardRetrieveCommand();
			command.execute(request, response);
			
			RequestDispatcher dis = request.getRequestDispatcher("/retrieve.jsp");
			dis.forward(request, response);
		}
		if("/delete".equals(action.trim())){ 
			BoardDeleteCommand command = new BoardDeleteCommand();
			command.execute(request, response);
			
			response.sendRedirect("/BoardProject/controller/list");
		}
		if("/update".equals(action.trim())){ 
			BoardUpdateCommand command = new BoardUpdateCommand();
			command.execute(request, response);
			
			response.sendRedirect("/BoardProject/controller/list");
		}
		if("/search".equals(action.trim())){ 
			BoardSearchCommand command = new BoardSearchCommand();
			command.execute(request, response);
			
			RequestDispatcher dis = request.getRequestDispatcher("/list.jsp");
			dis.forward(request, response);
		}
	}

}
