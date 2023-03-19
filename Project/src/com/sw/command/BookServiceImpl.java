package com.sw.command;

import java.util.ArrayList;
import com.sw.dao.BookDao;
import com.sw.dao.BookDaoImpl;
import com.sw.dto.BookDto;

public class BookServiceImpl implements BookService {
	
	public ArrayList<BookDto> showRentedBookList(String bClient) {
		BookDao dao = new BookDaoImpl();
		ArrayList<BookDto> dtos = dao.showRentedBookList(bClient);
		return dtos;
	}
	
	public ArrayList<BookDto> viewContent(String wh, String content){
		BookDao dao = new BookDaoImpl();
		ArrayList<BookDto> dtos = dao.viewContent(wh, content);
		return dtos;
	}
	
	public ArrayList<BookDto> viewBookDetail(String id){
		BookDao dao = new BookDaoImpl();
		ArrayList<BookDto> dtos = dao.viewBookDetail(id);
		return dtos;
	}

	@Override
	public ArrayList<BookDto> viewContentB() {
		// TODO Auto-generated method stub
		BookDao dao = new BookDaoImpl();
		ArrayList<BookDto> dtos = dao.viewContentB();
		return dtos;
	}
	
}