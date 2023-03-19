package com.sw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sw.dto.BookDto;

public class BookDaoImpl implements BookDao {
	
	// 대출중 도서 출력 메소드
	
	public ArrayList<BookDto> showRentedBookList(String bClient){
		
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select bId, bName, bAuthor, bPublisher from books where bClient=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bClient);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String bookId = rs.getString("bId");
				String bookName = rs.getString("bName");
				String bookAuthor = rs.getString("bAuthor");
				String bookPublisher = rs.getString("bPublisher");
				BookDto dto = new BookDto(bookId, bookName, bookAuthor, bookPublisher);
				dtos.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, conn);
		}
		
		return dtos;
		
	}
	
	// 도서 검색 메소드 - 검색창
	
	public ArrayList<BookDto> viewContent(String wh, String content) {
		
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from books where "+wh+" like '%"+content+"%'";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String dbId = rs.getString("bId");
				String dbName = rs.getString("bName");
				String dbAuthor = rs.getString("bAuthor");
				String dbPublisher = rs.getString("bPublisher");
				String dbClient = rs.getString("bClient");
				BookDto dto = new BookDto(dbId, dbName, dbAuthor, dbPublisher, dbClient);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, conn);
		}
		
		return dtos;
		
	}
	
public ArrayList<BookDto> viewContentB() {
		
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from books order by bId";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String dbId = rs.getString("bId");
				String dbName = rs.getString("bName");
				String dbAuthor = rs.getString("bAuthor");
				String dbPublisher = rs.getString("bPublisher");
				String dbClient = rs.getString("bClient");
				BookDto dto = new BookDto(dbId, dbName, dbAuthor, dbPublisher, dbClient);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, conn);
		}
		
		return dtos;
		
	}
	
	public ArrayList<BookDto> viewBookDetail(String id){
		
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from books where bId like '" + id + "%'";
			pstmt = conn.prepareStatement(query);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				String dbId = rs.getString("bId");
				String dbName = rs.getString("bName");
				String dbAuthor = rs.getString("bAuthor");
				String dbPublisher = rs.getString("bPublisher");
				String dbClient = rs.getString("bClient");
				String dbExplain = rs.getString("bExplain");
				BookDto dto = new BookDto(dbId, dbName, dbAuthor, dbPublisher, dbClient, dbExplain);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, conn);
		}
		
		return dtos;
		
	}
	
	// 커넥션 관련 메소드
	
	public Connection getConnection() {
		
		Connection conn = null;
		String DBName = "";
		String dbURL = "jdbc:mysql://localhost:/" + DBName;
		String sslStr = "?useSSL=false";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			System.out.println("* getConnection() - JDBC driver load success");
			conn = DriverManager.getConnection(dbURL + sslStr, "root", "");
			System.out.println("* getConnection() - DB connection success");
		} catch (ClassNotFoundException e) {
			System.out.println("* getConnection() - JDBC driver load fail");
		} catch (SQLException e) {
			System.out.println("* getConnection() - DB connection fail");
		}
		
		return conn;
		
	}
	
	public void closeConnection(ResultSet set, PreparedStatement pstmt, Connection con) {
		
		if(set != null){
			try{
				set.close();
				System.out.println("* closeConnection() - ResultSet close success");
			}catch(SQLException ex){
				System.out.println("* closeConnection() - ResultSet close exception");
			}
		}
		if(pstmt != null){
			try{
				pstmt.close();
				System.out.println("* closeConnection() - prepared statement close success");
			}catch(SQLException ex) {
				System.out.println("* closeConnection() - prepared statement close exception");
			}
		}
		if(con != null){
			try{
				con.close();
				System.out.println("* closeConnection() - connection close success");
			}catch (SQLException e) {
				System.out.println("* closeConnection() - connection close exception");
			}
		}
		
	}
	
	//================BDaoImpl===================
	@Override
	public ArrayList<BookDto> showBoardList1() {
		// TODO Auto-generated method stub
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			con = getConnection();
			String query = "select * from books order by bId";
			pstmt = con.prepareStatement(query);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				String dbId = rs.getString("bId");
				String dbName = rs.getString("bName");
				String dbAuthor = rs.getString("bAuthor");
				String dbPublisher = rs.getString("bPublisher");
				String dbClient = rs.getString("bClient");
				BookDto dto = new BookDto(dbId, dbName, dbAuthor, dbPublisher, dbClient);
				dtos.add(dto);
			}
		} catch (Exception e) {
			
		} finally {
			
		}
		return dtos;
	}
	@Override
	public ArrayList<BookDto> viewContent1(String wh, String content) {
		// TODO Auto-generated method stub
//	
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	
		try {
			con = getConnection();
			String query = "select * from books where "+wh+" like '%"+content+"%'";
			pstmt = con.prepareStatement(query);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				String dbId = rs.getString("bId");
				String dbName = rs.getString("bName");
				String dbAuthor = rs.getString("bAuthor");
				String dbPublisher = rs.getString("bPublisher");
				String dbClient = rs.getString("bClient");
				BookDto dto = new BookDto(dbId, dbName, dbAuthor, dbPublisher, dbClient);
				dtos.add(dto);
			}
		} catch (Exception e) {
			
		} finally {
			
		}
		return dtos;
	}
	
	@Override
	public void writeContent(BookDto bdto) {
		// TODO Auto-generated method stub
		int ret=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String bId=bdto.getbId();
		String bName=bdto.getbName();
		String bAuthor=bdto.getbAuthor();
		String bPublisher=bdto.getbPublisher();
		
		try {
			con = getConnection();

			String query = "insert into books  values ( ?, ?, ?, ?,null,null)";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bId);
			pstmt.setString(2, bName);
			pstmt.setString(3, bAuthor);
			pstmt.setString(4, bPublisher);

			ret=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
	}

	@Override
	public ArrayList<BookDto> bookDetail_viewContent(String id) {
		// TODO Auto-generated method stub
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	
		try {
			con = getConnection();
			String query = "select * from books where bId like '"+id+"%'";
			pstmt = con.prepareStatement(query);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				String dbId = rs.getString("bId");
				String dbName = rs.getString("bName");
				String dbAuthor = rs.getString("bAuthor");
				String dbPublisher = rs.getString("bPublisher");
				String dbClient = rs.getString("bClient");
				String dbExplain = rs.getString("bExplain");
				BookDto dto = new BookDto(dbId, dbName, dbAuthor, dbPublisher, dbClient, dbExplain);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
		return dtos;
	}

	@Override
	public int bookDetail_deleteABook(String id) {
		// TODO Auto-generated method stub
		int ret=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String query = "delete from books where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ret = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);

		}
		return ret;
	}

	@Override
	public int bookDetail_modifyABook(BookDto bdto) {
		// TODO Auto-generated method stub
		int ret=0;
		String bId=bdto.getbId();
		String bName=bdto.getbName();
		String bAuthor=bdto.getbAuthor();
		String bPublisher=bdto.getbPublisher();
		String bClient=bdto.getbClient();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			
			String query = "update books set bName = ?, bAuthor = ?, bPublisher = ?where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bAuthor);
			pstmt.setString(3, bPublisher);
			pstmt.setString(4, bId);
			ret = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
		return ret;
	}
}