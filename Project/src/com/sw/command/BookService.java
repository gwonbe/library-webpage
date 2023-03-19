package com.sw.command;

import java.util.ArrayList;
import com.sw.dto.BookDto;

public interface BookService {
	
	public ArrayList<BookDto> showRentedBookList(String bClient);
	public ArrayList<BookDto> viewContent(String wh, String content);
	public ArrayList<BookDto> viewContentB();
	public ArrayList<BookDto> viewBookDetail(String id);
	
}