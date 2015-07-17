package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;

import com.entity.BoardDTO;
/*
  create table board
  (num number(4) primary key,
  author varchar2(20) not null,
  title varchar2(20) not null,
  content varchar2(4000),
  writeday date default sysdate,
  readcnt number(4) default 0);
 
 create sequence board_seq;
 * */
import com.entity.PageDTO;

public class BoardDAO {
	static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "com/dao/configuration.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}// end static 블럭
	
	public int totalCount(){
		SqlSession session = sqlSessionFactory.openSession();
		
		int n = 0;
		try {
			n = session.selectOne("count");
		} finally {
			session.close();
		}
		return n;
		
	}
	//page
		public PageDTO page(int curPage){
			
			PageDTO list = new PageDTO();
			int perPage = list.getPerPage();
			int skip = (curPage - 1) * perPage;
			int totalCount = 0;
			SqlSession session = sqlSessionFactory.openSession();
			try {
				List<BoardDTO> xxx = session.selectList("list", null , new RowBounds(skip, perPage));
				list.setList(xxx);
				list.setCurPage(curPage);
				list.setTotalCount(totalCount);
			} finally {
				session.close();
			}
			return list;
			
		}//end list
	
	
	
	//글 목록보기
	public List<BoardDTO> list(){
		
		List<BoardDTO> list = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("list");
		} finally {
			session.close();
		}
		return list;
		
	}//end list
	
	//글쓰기
	public int write(BoardDTO dto){
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			n = session.insert("insert",dto);
			session.commit();
		} finally{
			session.close();
		}
		
		return n;
	}//end write
	
	//글 자세히 보기
	public BoardDTO retrieve(String num){
		
		readCnt(num);
		
		BoardDTO dto = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			dto = session.selectOne("selectByNum", Integer.parseInt(num));
			session.commit();
		} finally {
			session.close();
		}
		return dto;
	}//end retrieve
	
	//조회수 증가
		public void readCnt(String num){
			
			SqlSession session = sqlSessionFactory.openSession();
			try {
				int n = session.update("readCnt",Integer.parseInt(num));
				session.commit();
			} finally{
				session.close();
			}
			
		}
		
	//글 수정
	public int update(BoardDTO dto){
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			n = session.update("update",dto);
			session.commit();
		} finally{
			session.close();
		}
		
		return n;
	}//end update
	
	//글삭제하기
	public int delete(String num){
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			n = session.delete("delete", Integer.parseInt(num));
			session.commit();
		} finally{
			session.close();
		}
		
		return n;
	}
	
	//검색
	public List<BoardDTO> search(String searchName, String searchValue){
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		
		/*String key = "author";
		if("title".equals(searchName)){
			key = "title";
		}*/
		
		List<BoardDTO> list = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("search", map);
		} catch (Exception e) {
			session.close();
		}
		return list;
	}
	
}//end class
