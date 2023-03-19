package com.sw.command;

import com.sw.dao.MemberDao;
import com.sw.dao.MemberDaoImpl;
import com.sw.dto.MemberDto;

public class InsertCommand implements Service {

	@Override
	public int execute(MemberDto mdto) {
		
		MemberDao mdao = new MemberDaoImpl();
		int ret = mdao.insertMember(mdto);
		return ret;
		
	}

}
