package com.plant.service;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plant.dao.MemberDaoImp;
import com.plant.dto.Plantmember;

@Repository
public class MemberServiceimp implements MemberService {
	@Autowired
	private MemberDaoImp mdo;
	
	@Override
	public Map<String, String> login(String id, String pw) {
		
		//MemberDao에 loginProc()호출
		return mdo.loginProc(id, pw);
	}


	/*
	 * @Override public Plantmember pwfind(HttpServletRequest req,
	 * HttpServletResponse resp) { Plantmember pm = new Plantmember();
	 * pm.setId(req.getParameter("pwlostId"));
	 * pm.setName(req.getParameter("pwlostname"));
	 * pm.setEmail(req.getParameter("pwlostemail"));
	 * 
	 * return memberDao.pwFind(pm, resp);
	 * 
	 * }
	 */
	public Map<String, String> pwfind(String id, String name, String email) {
		
		
		return mdo.pwfind(id,name,email);
	}

	@Override
	public int insertMember(Plantmember member) {
		return mdo.insertMember(member);
	}

	@Override
	public Plantmember mypageEdit(Plantmember member) {
		return mdo.mypageEdit(member);
	}



	/*
	 * public int mypageEdit(HttpServletRequest req) { return
	 * memberDao.mypageEdit(req); }
	 */
	//public Plantmember mypageEditpage(String id) {
//		return mdo.mypageEditpage(id);
//	}



		

}
