package com.plant.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plant.dto.Plantmember;


public interface MemberService {

	Map<String, String> login(String id, String pw);
	
	public int insertMember(Plantmember member);
	
	public Map<String, String> pwfind(String id, String name, String email);
	
	public Plantmember mypageEdit(Plantmember member);



}
