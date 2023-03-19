package com.sw.command;

import com.sw.dto.MemberDto;

public interface MyPageService {
	
	public MemberDto viewInformation(String memberID);
	public void modifyInformation(MemberDto mdto);
	
}