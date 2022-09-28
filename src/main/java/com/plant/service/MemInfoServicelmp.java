package com.plant.service;

import java.util.List;

import com.plant.dao.MemInfoDao;
import com.plant.dto.MemInfo;
import com.plant.dto.Plantmember;


public class MemInfoServicelmp implements MemInfoService{
	MemInfoDao boardDao = new MemInfoDao(); 
	
	@Override
	public List<MemInfo> myboard(String id) {
		return boardDao.myboard(id);
	}
	@Override
	public List<MemInfo> myqnaboard(String id) {
		return boardDao.myqnaboard(id);
	}

	@Override
	public List<MemInfo> myadoptboard(String id) {
		return boardDao.myadoptboard(id);
	}
	
	@Override
	public List<MemInfo> myplantboard(String id) {
		return boardDao.myplantboard(id);
	}
	@Override
	public List<MemInfo> myadoptreviewboard(String id) {
		return boardDao.myadoptreviewboard(id);
	}

	@Override
	public List<MemInfo> myreply(String id) {
		return boardDao.myreply(id);
	}

	public List<MemInfo> myqnareplyboard(String id) {
		return boardDao.myqnareplyboard(id);
	}

	public Plantmember mypage(String id) {
		return boardDao.mypage(id);
	}

	@Override
	public MemInfo searchBoard(String seqno) {
		return boardDao.boardDetail(seqno);
	}



}
