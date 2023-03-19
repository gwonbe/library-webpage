package com.sw.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sw.command.BoardService;
import com.sw.command.BoardServiceImpl;
import com.sw.command.BookService;
import com.sw.command.BookServiceImpl;
import com.sw.command.InsertCommand;
import com.sw.command.LoginCommand;
import com.sw.command.MyPageService;
import com.sw.command.MyPageServiceImpl;
import com.sw.command.Service;
import com.sw.dto.BookDto;
import com.sw.dto.MemberDto;

/**
 * Servlet implementation class MyPageController
 */

@WebServlet("*.do")

public class LibraryController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public LibraryController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	// # actionDo
	
	/**
	 * @see HttpServlet#actionDo(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("\n~ actionDo ~");
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		System.out.println("- uri : " + uri);
		System.out.println("- conPath : " + conPath);
		System.out.println("- command : " + command);
		
		Service service = null;
		BoardService boCmd = new BoardServiceImpl();
		MyPageService mCmd = new MyPageServiceImpl();
		BookService bCmd = new BookServiceImpl();
		HttpSession session = request.getSession();
		String viewPage = null;
		
		int result;
		MemberDto mdto = new MemberDto();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		mdto.setMemberName(name);
		mdto.setMemberEmail(email);
		mdto.setMemberID(id);
		mdto.setMemberPW(pw);
		
		// *.do
		
		if(command.equals("/GoToMainPage.do")) {
			viewPage = "mainpage.jsp";
		}
		else if(command.equals("/MenuIntroduceLibrary.do")) {
			viewPage = "menu_introduce_library.jsp";
		}
		else if(command.equals("/MenuBookSearchPage.do")) {
			ArrayList<BookDto> bList = bCmd.viewContentB();
			session.setAttribute("bList", bList);
			viewPage = "menu_book_search.jsp";
		}
		else if(command.equals("/MenuBookSearch.do")) {
			String wh = request.getParameter("select_content");
			String content = request.getParameter("searchText");
			ArrayList<BookDto> bList = bCmd.viewContent(wh, content);
			session.setAttribute("bList", bList);
			viewPage = "menu_book_search_result.jsp";
		}
		else if(command.equals("/MenuBookSearchDetail.do")) {
			String bId = request.getParameter("bId");
			ArrayList<BookDto> bList = bCmd.viewBookDetail(bId);
			session.setAttribute("bList", bList);
			viewPage = "menu_book_detail.jsp";
		}
		else if(command.equals("/MenuMyPageViewInformation.do")) {
			String sID = request.getParameter("CId");
			if(sID.equals("") || sID.equals(" ") || sID.equals(null)) {
				viewPage = "fc_form_login.html";
			}
			else {
				MemberDto memberDto = mCmd.viewInformation(sID);
				ArrayList<BookDto> bList = bCmd.showRentedBookList(sID);
				session.setAttribute("viewInformation", memberDto);	
				session.setAttribute("bList", bList);
				viewPage = "menu_mypage.jsp";			
			}
		}
		else if(command.equals("/MenuMyPageModifyMyInformation.do")) {
			viewPage = "menu_mypage_modify_information.jsp";
		}
		else if(command.equals("/MenuMyPageModificationComplet.do")) {
			String sName = request.getParameter("memberName");
			String sEmail = request.getParameter("memberEmail");
			String sID = request.getParameter("memberID");
			String sPW = request.getParameter("memberPW");
			MemberDto memberDto = new MemberDto(sName, sEmail, sID, sPW);
			mCmd.modifyInformation(memberDto);
			viewPage = "mainpage.jsp";
		}
		
		// join & login & logout
		else if(command.equals("/join.do")) {
			service = new InsertCommand();
			result = service.execute(mdto);
			if(result == 1) {
				session.setAttribute("UserId", mdto.getMemberID());
				viewPage = "mainpage.jsp";
			}else {
				session.setAttribute("insertResult", "join fail");
				viewPage = "fc_form_join.html";
			}			
		}
		else if(command.equals("/login.do")) {
			service = new LoginCommand();
			result = service.execute(mdto);
			if(result == 1) {
				session.setAttribute("UserId", mdto.getMemberID());
				viewPage = "mainpage.jsp";
			}else {
				session.setAttribute("loginResult", "login fail");
				viewPage = "fc_form_login.html";
			}
		}else if(command.equals("/LogInOrLogOut.do")) {
			if(session.getAttribute("UserId") == null) {
				viewPage = "loginpage.jsp";
			}else {
				session.setAttribute("UserId", null);
				viewPage = "mainpage.jsp";
			}
		}
		
		//CFrontcontroller
		else if(command.equals("/admin_book.do")) { //list.do 실행할 되면 돌아갈 코드
			ArrayList<BookDto> bList =boCmd.showBoardList1();
			System.out.println(bList.size());
			session.setAttribute("bList", bList);
			viewPage = "admin_SearchBook.jsp";
		}else if(command.equals("/admin_client.do")) {
			ArrayList<MemberDto> cList = boCmd.showBoardList();
			System.out.println(cList.size());
			session.setAttribute("cList", cList);
			viewPage = "admin_SearchClient.jsp";
		} 
		else if(command.equals("/Csearch.do") || command.equals("/admin_client_result.do")) {
			String wh = request.getParameter("select_content");
			String content = request.getParameter("searchText");			
			ArrayList<MemberDto> cList= boCmd.viewContent(wh, content);
			System.out.println(cList.size());
			System.out.println(wh+content);
			session.setAttribute("cList", cList);
			viewPage = "admin_SearchClient_Result.jsp";
		}
		else if(command.equals("/Bsearch.do") || command.equals("/admin_book_result.do")) {
			String wh = request.getParameter("select_content");
			String content = request.getParameter("searchText");			
			ArrayList<BookDto> bList= boCmd.viewContent1(wh, content);
			System.out.println(bList.size());
			System.out.println(wh+content);
			session.setAttribute("bList", bList);
			viewPage = "admin_SearchBook_Result.jsp";
		} else if(command.equals("/write.do")) {
			String bId = request.getParameter("bId");
			String bName = request.getParameter("bName");
			String bAuthor = request.getParameter("bAuthor");
			String bPublisher = request.getParameter("bPublisher");
		
			BookDto bdto= new BookDto(bId, bName,bAuthor,bPublisher,null,null);			
			boCmd.writeContent(bdto);
			viewPage = "admin_book.do";
		}	else if(command.equals("/book_detail.do")){
			String bId = request.getParameter("bId");
			ArrayList<BookDto> bList=boCmd.bookDetail_viewContent(bId); //같은 책 소장하고 있는 것 모두 불러오기 
			session.setAttribute("bList",bList);
			System.out.println("실행됐는지 확인 " +bList.size());
			viewPage = "admin_bookDetail.jsp";
		}   else if(command.equals("/delete.do")) {
			String bId = request.getParameter("bId");
			boCmd.bookDetail_deleteABook(bId);
			viewPage = "admin_book.do"; // 여기서 그대로 admin_bookDetail.jsp 페이지를 보게 하면 삭제나 수정 전 데이터가 뜨기 때문에 그냥 목록으로 연결했음
		}	else if(command.equals("/modify.do")) {
			String bId = request.getParameter("bId");
			String bName = request.getParameter("bName");
			String bAuthor = request.getParameter("bAuthor");
			String bPublisher = request.getParameter("bPublisher");
			String bClient = request.getParameter("bClient");
			BookDto bdto= new BookDto(bId, bName,bAuthor,bPublisher,bClient);
			System.out.println(bPublisher);
			boCmd.bookDetail_modifyABook(bdto);
			viewPage = "admin_book.do";
		}
		response.sendRedirect(viewPage);
		
	}
	
}