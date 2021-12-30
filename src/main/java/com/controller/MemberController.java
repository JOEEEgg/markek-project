package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberSerivce;

@Controller
public class MemberController {
	@Autowired
	MemberSerivce service;
	
	//회원가입기능
	@RequestMapping(value = "/memberAdd")
	public String memberAdd(MemberDTO m,Model model) {
		System.out.println("member===="+m);
		service.memberAdd(m);
		model.addAttribute("success", "회원가입성공");
		return "main";
	}
	
	//아이디중복체크기능
	@RequestMapping(value = "/idDuplicateCheck", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String idCheck(@RequestParam("userid")String userid) {
		MemberDTO dto = service.myPage(userid);
		String mesg = "아이디 사용가능";
		if(dto!=null) {
			mesg = "아이디 중복";
		}
		return mesg; //메세지 전달
	}

	//myPage 기능
	@RequestMapping(value = "/loginCheck/mypage")
	public String myPage(HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String userid = dto.getUserid();
		dto = service.myPage(userid);
		session.setAttribute("login", dto);
		return "redirect:../mypage";
	}
	
	
	//회원정보수정기능
	@RequestMapping(value = "/loginCheck/memberUpdate")
	public String memberUpdate(MemberDTO m, HttpSession session) {
		System.out.println("memberUpdate===="+m);
		service.memberUpdate(m);
		session.setAttribute("login", m);
		return "redirect:../mypage"; //mypage호출
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
