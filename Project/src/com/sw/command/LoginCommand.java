package com.sw.command;

import com.sw.dao.MemberDao;
import com.sw.dao.MemberDaoImpl;
import com.sw.dto.MemberDto;

public class LoginCommand implements Service {

	@Override
	public int execute(MemberDto mdto) {
		
		int ret = 0;
		MemberDao mdao = new MemberDaoImpl();
		String id = mdto.getMemberID();
		String pw = mdto.getMemberPW();
		String dbpw = mdto.loginMember(id);
				
		if(pw.equals(dbpw)) {
			ret = 1;
		}else {
			ret = -1;
		}
		
		return ret;
		
	}

}
