package com.plant.controller.user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.plant.dto.Plantmember;
import com.plant.service.MemberService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lo/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired 
	private MemberService ms;

	@RequestMapping("loginview")
	public String loginview() {
		return "/member/login";
	}

	@RequestMapping("memRegForm")
	public String memRegForm() {
		return "/member/memregform";
	}
	@RequestMapping("signup")
	public String signup(Plantmember member) {

		ms.insertMember(member);
		return "/member/login";
	}



	@RequestMapping(value="logout.lo", method = RequestMethod.GET)
	public String logoutMainGET(HttpServletRequest req) throws Exception{
		logger.info("logoutMainGET메서드 진입");

		HttpSession session = req.getSession();

		session.invalidate();

		return "redirect:/"; 
	}


	@RequestMapping("pwfind")
	public String pwfind(Plantmember member) {
		ms.pwfind(member.getId(), member.getName(), member.getEmail());
		return"/member/pwfind";
	}
}






/*
 * else if(cmd.equals("pwlost")) { goView(req, resp, "/member/pwlost.jsp"); }
 * 
 * else if(cmd.equals("memberReg")) { System.out.println("회원등록 요청");
 * memberService.insert(req); req.setAttribute("msg", "memberOk"); goView(req,
 * resp, "/member/login.jsp"); } else if(cmd.equals("pwfind")) {
 * 
 * 
 * 
 * String id = req.getParameter("pwlostId"); String name =
 * req.getParameter("pwlostname"); String email =
 * req.getParameter("pwlostemail"); Map<String, String> find =
 * memberService.pwfind(id, name, email);
 * 
 * String viewPage=null; if(find.get("find").equals("pwfind")) {
 * req.setAttribute("member", memberService.pwfind(id, name, email));
 * //req.setAttribute("pw", find.get("pw")); viewPage="/member/pwfind.jsp";
 * }else {
 * 
 * viewPage="/member/pwlost.jsp"; } req.setAttribute("find", find.get("find"));
 * goView(req, resp, viewPage);
 * 
 * }
 * 
 * else if(cmd.equals("mypageEditpage")) { String id = null;
 * 
 * HttpSession sess = req.getSession(); LoginImpl log =
 * (LoginImpl)sess.getAttribute("loginUser"); Plantmember member =
 * memberService.mypageEditpage(id); req.setAttribute("member", member);
 * goView(req, resp, "/member/mypageEdit.jsp"); } } }
 */
