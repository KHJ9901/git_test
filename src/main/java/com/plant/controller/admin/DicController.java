package com.plant.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.plant.common.LoginImpl;
import com.plant.dto.*;
import com.plant.service.*;

@Controller
@RequestMapping(value="/mgDic/")
public class DicController {

	@Autowired
	DicService ds;
	
//-----------------------------관리자 사전 리스트--------------------------------------------
	@RequestMapping(value="dictionary", method= {RequestMethod.POST, RequestMethod.GET})
	public String Diclist(Criteria cri, Model model) {
		if(cri.getCurrentPage() == 0) cri.setCurrentPage(1);
		if(cri.getRowPerpage() == 0) cri.setRowPerpage(10);
		
		List<Dictionary> diction = ds.list(cri);
		
		model.addAttribute("pageMaker", new Page(ds.getDicRec(cri), cri));			
		model.addAttribute("diction", diction);
		return "/dictionary/mgDictionary";
		
	}
	
	@RequestMapping(value="mplant", method= {RequestMethod.POST, RequestMethod.GET})
	public String list(Criteria cri, Model model) {
		if(cri.getCurrentPage() == 0) cri.setCurrentPage(1);
		if(cri.getRowPerpage() == 0) cri.setRowPerpage(10);
		
		List<Mplant> mplant = ds.mpList(cri);
		
		model.addAttribute("pageMaker", new Page(ds.getMplantRec(cri), cri));			
		model.addAttribute("mplant", mplant);
		return "/dictionary/mgMplant";
		
	}
	
	
	
//-----------------------------관리자 사전&회원식물 상세페이지--------------------------------------------
	@GetMapping("dicDetail") 
	public String dicdetail(@ModelAttribute("seqno") String seqno, 
												     Model model) {
		
		model.addAttribute("diction", ds.DicDetail(seqno));
		
		return "/dictionary/mgDicDetail";
	}
	
	@GetMapping("mplantDetail") 
	public String mpdetail(@ModelAttribute("seqno") String seqno, 
												    Model model) {
		
		model.addAttribute("diction", ds.MpDetail(seqno));
		
		return "/dictionary/memPlantDetail";
	}
	
	
//-----------------------------관리자 사전 등록 뷰페이지 이동--------------------------------------------
	
	@GetMapping("mgDicRegForm")
	public void regForm() {
	}
	
	//회원 식물 수정 페이지//
	@GetMapping("mgDicModify")
	public void modifyForm(@ModelAttribute("seqno") String seqno,
													  Model model) {
		model.addAttribute("dictiondetail", ds.DicDetail(seqno));
	}
//-----------------------------관리자 사전 식물 삽입--------------------------------------------
	@PostMapping("insertDictionary")
	public String register(Dictionary diction, 
						   MultipartFile filename,
						   HttpSession sess,
						   RedirectAttributes rttr) { //리다이렉트 할때 필요함
		
		diction.setId(((LoginImpl)sess.getAttribute("loginUser")).getId());
		
		rttr.addFlashAttribute("seqno", ds.insertDic(diction, filename)); 
			// addFlash는 객체를 담음
		
		return "redirect:dictioanryDetail";
	}
	//-----------------------------회원 식물 수정--------------------------------------------
	@PostMapping("updateDictionary")
	public String update  (Dictionary diction, 
						   MultipartFile filename,
						   HttpSession sess,
						   RedirectAttributes rttr) { //리다이렉트 할때 필요함
		
		diction.setId(((LoginImpl)sess.getAttribute("loginUser")).getId());
		
		rttr.addFlashAttribute("seqno", ds.updateDic(diction, filename)); 
			// addFlash는 객체를 담음
		
		return "redirect:/dictionary/dictioanryDetail";
	}
	
	//-----------------------------회원 식물 삭제--------------------------------------------
	@PostMapping("deleteDictionary")
	public String register(Dictionary diction, 
						   String seqno,
						   HttpSession sess) {
		
		diction.setId(((LoginImpl)sess.getAttribute("loginUser")).getId());
		
		ds.deleteDic(seqno); 
		
		return "redirect:dictionary";
	}
}