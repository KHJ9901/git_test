package com.plant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.plant.dto.*;

public interface DictionaryMapper {
	
	//--------------------------사전 관련-----------------------------------
	public Dictionary getKname(String seqno); //MemberMapper.xml 에 있는 select id
	
	public List<Dictionary> dictionList(@Param("cri") Criteria cri, 
										@Param("sno") Long sno);
	
	public List<Dictionary> dictionInList(@Param("cri") Criteria cri, 
										  @Param("sno") Long sno);
	
	public List<Dictionary> dictionOutList(@Param("cri") Criteria cri, 
										   @Param("sno") Long sno);
	
	public Dictionary dictionDetail(Long sno);
	
	public String dictionInsert(Dictionary diction, DicImg dicImgUpload);
	
	public Dictionary dictionUpdate(Dictionary diction, DicImg dicImgUpload);
	
	public Dictionary dictionDelete(Long sno);
	
	
	//--------------------------회원 식물 관련-----------------------------------
	public List<Mplant> mplantList(@Param("cri") Criteria cri, 
								   @Param("sno") Long sno);
	
	public Mplant MplantDetail(Long sno);
	
	public Mplant MplantInsert(Mplant mplant, MplantImg mpImgUpload);
	
	public Mplant MplantUpdate(Mplant mplant, MplantImg mpImgUpload);
	
	public Mplant MplantDelete(Long sno);


}
