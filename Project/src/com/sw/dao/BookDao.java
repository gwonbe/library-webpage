package com.sw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.sw.dto.BookDto;

public interface BookDao {

	// 대출중 도서 출력 메소드
	public ArrayList<BookDto> showRentedBookList(String bClient);
	
	// 도서 검색 메소드
	public ArrayList<BookDto> viewContent(String wh, String content);
	public ArrayList<BookDto> viewContentB();
	public ArrayList<BookDto> viewBookDetail(String id);
	
	// 커넥션 관련 메소드
	public Connection getConnection();
	public void closeConnection(ResultSet set, PreparedStatement pstmt, Connection con);	
	
	//BDao
	public ArrayList<BookDto> showBoardList1(); //전체 항목 출력
	public ArrayList<BookDto> viewContent1(String wh, String content);
	public void writeContent(BookDto bdto);
	public ArrayList<BookDto> bookDetail_viewContent(String id); //책 한 권 detail 창
	public int bookDetail_deleteABook(String id);
	public int bookDetail_modifyABook(BookDto bdto);
	
}