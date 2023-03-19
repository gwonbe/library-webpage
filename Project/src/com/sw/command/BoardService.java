package com.sw.command;

import java.util.ArrayList;

import com.sw.dto.*;

public interface BoardService {
	ArrayList<MemberDto> showBoardList(); //client method
	ArrayList<MemberDto> viewContent(String wh, String content);
	
	
	ArrayList<BookDto> showBoardList1(); //book method
	ArrayList<BookDto> viewContent1(String wh, String content);
	public void writeContent(BookDto bdto); //book add
	
	ArrayList<BookDto> bookDetail_viewContent(String id);
	public int bookDetail_deleteABook(String id);
	public void bookDetail_modifyABook(BookDto bdto);

}
