package com.plant.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.plant.dto.*;

public interface DicService {
	//---------------리스트 조회--------------------//
	public List<Dictionary> list(Criteria cri, Long sno);
	
	public List<Dictionary> inList(Criteria cri, Long sno);

	public List<Dictionary> outList(Criteria cri, Long sno);

	public List<Mplant> mpList(Criteria cri, Long sno);
	
	
	//---------------상세페이지--------------------//
	public Dictionary DicDetail(Long sno);

	public Mplant MpDetail(Long sno);
	
	

	//---------------삽입--------------------//	
	public String insertMp(Mplant mplant, MultipartFile files);
	
	public String insertDic(Dictionary diction, MultipartFile files);
	
	
	//---------------수정--------------------//
	public String updateMp(Mplant mplant, MultipartFile files);
	
	public String updateDic(Dictionary diction, MultipartFile files);
	
	//---------------삭제--------------------//
	public void deleteMp(String seqno);
	
	public void deleteDic(String seqno);

	int getDicRec(Criteria criteria);

	int getDicInRec(Criteria criteria);

	int getDicOutRec(Criteria criteria);

	int getMplantRec(Criteria criteria);
	





}
