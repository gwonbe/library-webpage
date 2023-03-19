package com.sw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sw.dto.MemberDto;

public class MemberDaoImpl implements MemberDao {
	
	// 로그인 회원가입 관련 메소드
	
	public int insertMember(MemberDto mdto) {
		
		Connection conn = getConnection();
		ResultSet set = null;
		PreparedStatement pstmt = null;
		int ret = 0;
		String sql = "insert into client (CName, CEmail, CId, CPw) values (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			String name = mdto.getMemberName();
			String email = mdto.getMemberEmail();
			String id = mdto.getMemberID();
			String pw = mdto.getMemberPW();
			if(id.equals("") || id.equals(" ") || id.equals(null)) {
				ret = -1;
			}else {
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				pstmt.setString(3, id);
				pstmt.setString(4, pw);
				ret = pstmt.executeUpdate();
			}
		}catch (SQLException e){
			ret = -1;
			System.out.println("access error.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			closeConnection(null,pstmt,conn);
		}
		
		return ret;
		
	}
	
	public String loginMember(String id) {
		
		Connection conn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select CPw from client where CId = ?";
		String pwDb = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pwDb = rs.getString("CPw");
			}
		}catch (SQLException e){
			System.out.println("SQL exception");
			e.printStackTrace();
		}finally {
			closeConnection(rs,pstmt,conn);
		}
		
		return pwDb;
		
	}
	
	// 마이페이지 기능 관련 메소드
	
	public MemberDto viewInformation(String memberID) {
		
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select * from client where CId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbName = rs.getString("CName");
				String dbEmail = rs.getString("CEmail");
				String dbID = rs.getString("CId");
				String dbPW = rs.getString("CPw");
				dto = new MemberDto(dbName, dbEmail, dbID, dbPW);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(rs, pstmt, conn);
		}
		
		return dto;
		
	}
	
	public int modifyInformation(MemberDto mdto) {
		
		int ret = 0;
		
		String sID = mdto.getMemberID();
		String sPW = mdto.getMemberPW();
		String sName = mdto.getMemberName();
		String sEmail = mdto.getMemberEmail();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "update client set CName=?, CEmail=?, CPw=? where CId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sName);
			pstmt.setString(2, sEmail);
			pstmt.setString(3, sPW);
			pstmt.setString(4, sID);
			ret = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, conn);
		}
		
		return ret;
		
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
	
	
	//CDaoImpl==============
	
	@Override
	public ArrayList<MemberDto> showBoardList() {
		// TODO Auto-generated method stub
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			con = getConnection();
			String query = "select * from Client order by CName";
			pstmt = con.prepareStatement(query);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				String dbName = rs.getString("CName");
				String dbEmail = rs.getString("CEmail");
				String dbId = rs.getString("CId");
				String dbPw = rs.getString("CPw");
				MemberDto dto = new MemberDto(dbName,dbEmail,dbId,dbPw);
				dtos.add(dto);
			}
		} catch (Exception e) {
			
		} finally {
			
		}
		return dtos;
	}
	
	@Override
	public ArrayList<MemberDto> viewContent(String wh, String content) {
		// TODO Auto-generated method stub
//	
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	
		try {
			con = getConnection();
			String query = "select * from Client where "+wh+" like '%"+content+"%'";
			pstmt = con.prepareStatement(query);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				String dbName = rs.getString("CName");
				String dbEmail = rs.getString("CEmail");
				String dbId = rs.getString("CId");
				String dbPw = rs.getString("CPw");
				MemberDto dto = new MemberDto(dbName,dbEmail,dbId,dbPw);
				dtos.add(dto);
			}
		} catch (Exception e) {
			
		} finally {
			
		}
		return dtos;
	}
}