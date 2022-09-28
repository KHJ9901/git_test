package com.plant.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.plant.service.*;
import com.plant.common.*;
import com.plant.dao.*;
import com.plant.dto.*;
import com.plant.mapper.*;

@Service
public class DicServicelmp implements DicService{
	
	private static final Logger log = LoggerFactory.getLogger(DicServicelmp.class);
	
	@Autowired
	private DictionaryMapper dicmapper; 
	private DicImgFileService mpfs;
	
	
	//---------------리스트 조회--------------------//
	@Override
	public List<Dictionary> list(Criteria cri, Long sno) {
		return dicmapper.dictionInList(cri, sno);
	}
	
	@Override
	public List<Dictionary> inList(Criteria cri, Long sno) {
		return dicmapper.dictionInList(cri, sno);
	}

	@Override
	public List<Dictionary> outList(Criteria cri, Long sno) {
		return dicmapper.dictionOutList(cri, sno);
	}

	@Override
	public List<Mplant> mpList(Criteria cri, Long sno) {
		return dicmapper.mplantList(cri, sno);
	}
	
	
	
	//---------------상세페이지--------------------//
	@Override
	public Dictionary DicDetail(Long sno) {
		return dicmapper.dictionDetail(sno);
	}
	
	@Override
	public Mplant MpDetail(Long sno) {
		return dicmapper.MplantDetail(sno);
	}
	
	
	
	//---------------삽입--------------------//	
	@Override
	public String insertMp(Mplant mplant, MultipartFile files) {
		
		return dicmapper.insertMplant(mplant, mpfs.mpImgUpload(files));
	}
	
	@Override
	public String insertDic(Dictionary diction, MultipartFile files) {
		
		DicImgFileService mpfs = new DicImgServiceImp();
		
		return dicDao.insertDiction(diction, mpfs.dicImgUpload(files));
	}
	
	
	
	//---------------수정--------------------//
	@Override
	public String updateDic(Dictionary diction, MultipartFile files) {
		
		DicImgFileService mpfs = new DicImgServiceImp();
		
		return dicDao.updateDiction(diction, mpfs.dicImgUpload(files));
		
	}
	
	@Override
	public String updateMp(Mplant mplant, MultipartFile files) {

		DicImgFileService mpfs = new DicImgServiceImp();
		
		return dicDao.updateMplant(mplant, mpfs.mpImgUpload(files));
	}
		
	
	//---------------삭제--------------------//
	@Override
	public void deleteMp(String seqno) {
		Map<String, String> map = dicDao.deleteMplant(seqno);
		
		String savefilename = map.get("savefilename");
		String filepath = map.get("filepath");
		String thumb_filename = map.get("thumb_filename");
		
		if(savefilename != null) {		
			//첨부파일삭제
			File file = new File(filepath+savefilename);
			if(file.exists()) {
				file.delete();				
			}
			
			//썸네일 삭제
			if(thumb_filename != null) {
				File thumb_file = new File(filepath + "thumbnail/" + thumb_filename);
				if(thumb_file.exists()) {
					thumb_file.delete();
				}
			}
		}
		
	}
	@Override
	public void deleteDic(String seqno) {
		Map<String, String> map = dicDao.deleteDiction(seqno);
		
		String savefilename = map.get("savefilename");
		String filepath = map.get("filepath");
		String thumb_filename = map.get("thumb_filename");
		
		if(savefilename != null) {		
			//첨부파일삭제
			File file = new File(filepath+savefilename);
			if(file.exists()) {
				file.delete();				
			}
			
			//썸네일 삭제
			if(thumb_filename != null) {
				File thumb_file = new File(filepath + "thumbnail/" + thumb_filename);
				if(thumb_file.exists()) {
					thumb_file.delete();
				}
			}
		}
		
	}
	
	//---------------총 개수--------------------//
	@Override
	public int getDicRec(Criteria criteria) {
		
		return dicDao.getDictionaryRec(criteria);
	}
	@Override
	public int getDicInRec(Criteria criteria) {
		
		return dicDao.getDictionaryInRec(criteria);
	}
	@Override
	public int getDicOutRec(Criteria criteria) {
		
		return dicDao.getDictionaryOutRec(criteria);
	}
	@Override
	public int getMplantRec(Criteria criteria) {
		
		return dicDao.getMplantRec(criteria);
	}
	
	
	
	//---------------파라미터--------------------//
	private Mplant getFormParameter(FileItem item, Mplant mplant) {
		System.out.printf("필드이름 : %s, 필드값: %s\n", item.getFieldName() /*input 타입의 필드 이름불러옴*/, item.getString());
		
		if(item.getFieldName().equals("reg_pname")) {
			mplant.setName(item.getString());
		}
		if(item.getFieldName().equals("reg_pcate")) {
			mplant.setCate(item.getString());
		}
		if(item.getFieldName().equals("reg_plevel")) {
			mplant.setPlevel(item.getString());
		}
		if(item.getFieldName().equals("seqno")) {
			mplant.setMplant_seqno(item.getString());
		}
		if(item.getFieldName().equals("reg_pwater")) {
			mplant.setWater(item.getString());
		}
		if(item.getFieldName().equals("reg_pplace")) {
			mplant.setPlace(item.getString());
		}
		if(item.getFieldName().equals("reg_ptemp")) {
			mplant.setTemp(item.getString());
		}
		if(item.getFieldName().equals("reg_pmoist")) {
			mplant.setMoist(item.getString());
		}
		if(item.getFieldName().equals("reg_petc")) {
			mplant.setEtc(item.getString());
		}
		
		return mplant;
	}
	
	private Dictionary getFormParameter(FileItem item, Dictionary diction) {
		System.out.printf("필드이름 : %s, 필드값: %s\n", item.getFieldName() /*input 타입의 필드 이름불러옴*/, item.getString());
		
		if(item.getFieldName().equals("reg_pkname")) {
			diction.setKname(item.getString());
		}
		if(item.getFieldName().equals("reg_pename")) {
			diction.setEname(item.getString());
		}
		if(item.getFieldName().equals("reg_pcate")) {
			diction.setCate(item.getString());
		}
		if(item.getFieldName().equals("seqno")) {
			diction.setSeqno(item.getString());
		}
		if(item.getFieldName().equals("reg_pwater")) {
			diction.setWater(item.getString());
		}
		if(item.getFieldName().equals("reg_pplace")) {
			diction.setPlace(item.getString());
		}
		if(item.getFieldName().equals("reg_ptemp")) {
			diction.setTemp(item.getString());
		}
		if(item.getFieldName().equals("reg_pmoist")) {
			diction.setMoist(item.getString());
		}
		if(item.getFieldName().equals("reg_petc")) {
			diction.setEtc(item.getString());
		}
		
		return diction;
	}



}