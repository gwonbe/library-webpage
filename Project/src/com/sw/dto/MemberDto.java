package com.sw.dto;

import com.sw.dao.MemberDao;
import com.sw.dao.MemberDaoImpl;

public class MemberDto {
	
	// field
	
	public String memberName;
	public String memberEmail;
	public String memberID;
	public String memberPW;
	
	// Constructor
	
	public MemberDto() {
		
	}
	
	public MemberDto(String memberName, String memberEmail, String memberID, String memberPW) {
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberID = memberID;
		this.memberPW = memberPW;
	}
	
	// getters and setters
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberPW() {
		return memberPW;
	}
	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}
	
	// method
	
	public String loginMember(String id) {
		MemberDao mdao = new MemberDaoImpl();
		return mdao.loginMember(id);
	}	
	
}