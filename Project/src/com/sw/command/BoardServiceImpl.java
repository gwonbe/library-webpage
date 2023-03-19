package com.sw.command;

import java.util.ArrayList;

import com.sw.dao.BookDao;
import com.sw.dao.BookDaoImpl;
import com.sw.dao.MemberDao;
import com.sw.dao.MemberDaoImpl;
import com.sw.dto.BookDto;
import com.sw.dto.MemberDto;


public class BoardServiceImpl implements BoardService {

	@Override
	public ArrayList<MemberDto> showBoardList() {
		// TODO Auto-generated method stub
		MemberDao cdao = new MemberDaoImpl();
		ArrayList<MemberDto> dtos = cdao.showBoardList();
//		dtos.add(new CDto("hi","hello","why","omg")); // 확인용 코드
		return dtos;
	}

	@Override
	public ArrayList<MemberDto> viewContent(String wh, String content) {
		// TODO Auto-generated method stub
		MemberDao cdao = new MemberDaoImpl();
		ArrayList<MemberDto> dtos = cdao.viewContent(wh,content);
		return dtos;
	}
	
	@Override
	public ArrayList<BookDto> showBoardList1() {
		// TODO Auto-generated method stub
		BookDao bdao = new BookDaoImpl();
		ArrayList<BookDto> dtos = bdao.showBoardList1();
		return dtos;
	}

	@Override
	public ArrayList<BookDto> viewContent1(String wh, String content) {
		// TODO Auto-generated method stub
		BookDao bdao = new BookDaoImpl();
		ArrayList<BookDto> dtos = bdao.viewContent1(wh,content);
		return dtos;
	}
	
	@Override
	public void writeContent(BookDto bdto) {
		// TODO Auto-generated method stub
		BookDao dao = new BookDaoImpl();
		dao.writeContent(bdto);
	}

	@Override
	public ArrayList<BookDto> bookDetail_viewContent(String id) {
		// TODO Auto-generated method stub
		BookDao bdao = new BookDaoImpl();
		ArrayList<BookDto> dtos = bdao.bookDetail_viewContent(id);
		return dtos;
	}

	@Override
	public int bookDetail_deleteABook(String id) {
		// TODO Auto-generated method stub
		int ret=0;
		BookDao dao = new BookDaoImpl();
		ret=dao.bookDetail_deleteABook(id);
		return ret;
	}

	@Override
	public void bookDetail_modifyABook(BookDto bdto) {
		// TODO Auto-generated method stub
		BookDao dao = new BookDaoImpl();
		dao.bookDetail_modifyABook(bdto);
	}

}
