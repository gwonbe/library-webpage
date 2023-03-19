package com.sw.command;

import com.sw.dao.MemberDao;
import com.sw.dao.MemberDaoImpl;
import com.sw.dto.MemberDto;

public class MyPageServiceImpl implements MyPageService {
	
	public MemberDto viewInformation(String memberID) {
		MemberDao dao = new MemberDaoImpl();
		MemberDto dto = dao.viewInformation(memberID);
		return dto;
	}
	
	public void modifyInformation(MemberDto mdto) {
		MemberDao dao = new MemberDaoImpl();
		dao.modifyInformation(mdto);
	}
	
}