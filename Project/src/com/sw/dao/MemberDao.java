package com.sw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.sw.dto.MemberDto;

public interface MemberDao {
	
	// 로그인 회원가입 관련 메소드
	public int insertMember(MemberDto mdto);
	public String loginMember(String id);
	
	// 마이페이지 기능 관련 메소드
	public MemberDto viewInformation(String memberID);
	public int modifyInformation(MemberDto mdto);
	
	// 커넥션 관련 메소드
	public Connection getConnection();
	public void closeConnection(ResultSet set, PreparedStatement pstmt, Connection con);
	
	//CDao
	public ArrayList<MemberDto> showBoardList(); //전체 항목 출력
	public ArrayList<MemberDto> viewContent(String wh, String content); // 항목 검사(반복문을 통해 검색)
	
}