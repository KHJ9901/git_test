package com.plant.controller.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.plant.common.LoginImpl;
import com.plant.dto.MemInfo;
import com.plant.dto.Plantmember;
import com.plant.service.*;

@WebServlet(urlPatterns = {"/me/*"})
public class MemInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemInfoController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();	
		String cmd = uri.substring(uri.lastIndexOf("/")+1);

		System.out.println("cmd=" + cmd);
		MemInfoService memInfoService = new MemInfoServicelmp();

		/*
		 * if(cmd.equals("boardList.bo")) { //게시판 리스트 List<Board> board =
		 * boardService.list(); req.setAttribute("board", board); goView(req, resp,
		 * "/board/boardList.jsp");
		 * 
		 * } else*/
		 
		 if(cmd.equals("myboard")) {
			 //게시판 리스트
			 HttpSession sess = req.getSession();
			 LoginImpl log = (LoginImpl)sess.getAttribute("loginuser");
			 List<MemInfo> board = memInfoService.myboard(((LoginImpl)sess.getAttribute("loginUser")).getId());
			 req.setAttribute("board", board);
			 goView(req, resp, "/member/myboard.jsp");

		 }else if(cmd.equals("myqnaboard")) {
			 //게시판 리스트
			 HttpSession sess = req.getSession();
			 LoginImpl log = (LoginImpl)sess.getAttribute("loginuser");
			 List<MemInfo> board = memInfoService.myqnaboard(((LoginImpl)sess.getAttribute("loginUser")).getId());
			 req.setAttribute("board", board);
			 goView(req, resp, "/member/myqnaboard.jsp");
		 }else if(cmd.equals("myadoptboard")) {
			 //게시판 리스트
			 HttpSession sess = req.getSession();
			 LoginImpl log = (LoginImpl)sess.getAttribute("loginuser");
			 List<MemInfo> board = memInfoService.myadoptboard(((LoginImpl)sess.getAttribute("loginUser")).getId());
			 req.setAttribute("board", board);
			 goView(req, resp, "/member/myadoptboard.jsp");
		 }else if(cmd.equals("myplantboard")) {
			 //게시판 리스트
			 HttpSession sess = req.getSession();
			 LoginImpl log = (LoginImpl)sess.getAttribute("loginuser");
			 List<MemInfo> board = memInfoService.myplantboard(((LoginImpl)sess.getAttribute("loginUser")).getId());
			 req.setAttribute("board", board);
			 goView(req, resp, "/member/myplantboard.jsp");
		 
		 }else if(cmd.equals("myadoptreviewboard")) {
				//게시판 리스트
				HttpSession sess = req.getSession();
				LoginImpl log = (LoginImpl)sess.getAttribute("loginuser");
				List<MemInfo> board = memInfoService.myadoptreviewboard(((LoginImpl)sess.getAttribute("loginUser")).getId());
				req.setAttribute("board", board);
				goView(req, resp, "/member/myadoptreviewboard.jsp");
		 }
		 else if(cmd.equals("myreply")) {
				//게시판 리스트
				HttpSession sess = req.getSession();
				LoginImpl log = (LoginImpl)sess.getAttribute("loginuser");
				List<MemInfo> board = memInfoService.myreply(((LoginImpl)sess.getAttribute("loginUser")).getId());
				req.setAttribute("board", board);
				goView(req, resp, "/member/myreply.jsp");
		 }
		 else if(cmd.equals("myqnareplyboard")) {
				//게시판 리스트
				HttpSession sess = req.getSession();
				LoginImpl log = (LoginImpl)sess.getAttribute("loginUser");
				List<MemInfo> board = memInfoService.myqnareplyboard(((LoginImpl)sess.getAttribute("loginUser")).getId());
				req.setAttribute("board", board);
				goView(req, resp, "/member/myqnareplyboard.jsp");
		 }
		 
		   else if(cmd.equals("mypage")) { //게시판 세부내용 List<Board> board =
			   HttpSession sess = req.getSession();
				LoginImpl log = (LoginImpl)sess.getAttribute("loginUser");
				Plantmember board = memInfoService.mypage(((LoginImpl)sess.getAttribute("loginUser")).getId());
					System.out.println("컨트롤러 ID : " + board.getId());
				req.setAttribute("board", board);
			   goView(req, resp, "/member/mypage.jsp"); }
		  
	}
	void goView(HttpServletRequest req, HttpServletResponse resp, String viewPage) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);

	}
}