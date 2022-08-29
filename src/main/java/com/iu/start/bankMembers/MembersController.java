package com.iu.start.bankMembers;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.bankAccount.BankAccountService;

@Controller
@RequestMapping(value="/member/*")
public class MembersController {
	

	@Autowired
	private BankMembersService bankMembersService;
//	@Autowired
//	private BankAccountService bankAccountService;
	
	
	
	@RequestMapping(value="logout.iu", method=RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		System.out.println("GET 로그아웃");
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value="login.iu", method=RequestMethod.GET)
	public String login() {
		System.out.println("GET 로그인 실행");
		return "member/login";
	}
	
	@RequestMapping(value="login.iu", method=RequestMethod.POST)
	public String login(HttpServletRequest request, BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("DB 로그인 실행");
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);
		return "redirect:../";
	}
	
	@RequestMapping(value="join.iu", method=RequestMethod.GET)
	public String setJoin() {
		System.out.println("GET 가입 실행");
		return "member/join";
	}
	
	@RequestMapping(value = "join.iu", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception {
		
		System.out.println("업로드시 파일명 - "+photo.getOriginalFilename());
		System.out.println("업로드 파라미터이름 - "+photo.getName());
		System.out.println("업로드시 파일크기"+photo.getSize());
		int result = bankMembersService.setJoin(bankMembersDTO,photo, session.getServletContext());
	
		
		
		return "redirect:./login.iu";
	}
	
	@RequestMapping(value = "search.iu", method = RequestMethod.GET)
	public String getSearchByID() throws Exception {
		System.out.println("서치 실행");
		return "member/search";
	}
	
	@RequestMapping(value = "search.iu", method = RequestMethod.POST)
	public String getSearchByID(String search, Model model) throws Exception {
		System.out.println("post 서치 실행");
		
		List<BankMembersDTO> ar = bankMembersService.getSearchByID(search);
		model.addAttribute("list", ar);
		return "member/list";
	}
	
	@RequestMapping(value = "myPage.iu", method = RequestMethod.GET)
	public ModelAndView getMyPage(HttpSession session) throws Exception {
		System.out.println("get mypage 실행");
		ModelAndView mv = new ModelAndView();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		bankMembersDTO = bankMembersService.getMyPage(bankMembersDTO);
//		List<BankAccountDTO> ar = bankAccountService.getListByUserName(bankMembersDTO);
//		mv.addObject("list", ar);
		mv.addObject("dto", bankMembersDTO);
		mv.setViewName("member/myPage");
		return mv;
		
	}
	
	
	
	
	
}
