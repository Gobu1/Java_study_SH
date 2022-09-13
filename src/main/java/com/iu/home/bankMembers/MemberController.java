package com.iu.home.bankMembers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.bankAccount.BankAccountDTO;
import com.iu.home.bankAccount.BankAccountService;


@Controller 
@RequestMapping(value="/member/*")
//�씠 �겢�옒�뒪�뒗 Controller�뿭�븷, 
//Container�뿉寃� �씠 �겢�옒�뒪�쓽 媛앹껜瑜� �깮�꽦 �쐞�엫
public class MemberController {
	
	@Autowired
	private BankMembersService bankMembersService;
//	@Autowired
//	private BankAccountService bankAccountService;
	
	@GetMapping("agree.iu")
	public String getAgree()throws Exception{
		return "member/agree";
	}
	
	@RequestMapping(value = "myPage.iu", method = RequestMethod.GET)
	public ModelAndView myPage(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
//		Map<String, Object> map = bankMembersService.getMyPage(bankMembersDTO);
//		mv.addObject("map", map);
		
		bankMembersDTO = bankMembersService.getMyPage(bankMembersDTO);
		//List<BankAccountDTO> ar = bankAccountService.getListByUserName(bankMembersDTO);
		
		//mv.addObject("list", ar);
		mv.addObject("dto", bankMembersDTO);
		
		mv.setViewName("member/myPage");
		return mv;
	}
	
	// annotation
	// @ : �꽕紐�+�떎�뻾
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	//  /member/login // �젅��寃쎈줈 �옉�꽦
	@RequestMapping(value = "login.iu", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	@RequestMapping(value = "login.iu", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, BankMembersDTO bankMembersDTO, Model model) throws Exception {
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		ModelAndView mv = new ModelAndView();
		//HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);
		int result = 0;
		String message = "로그인 실패";
		String url = "../member/login.iu";
		if(bankMembersDTO != null) {
			message = "로그인 성공";
			result = 1;
			url = "../";
		}
		
		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", url);
		mv.setViewName("common/result");
		
		// "redirect:�떎�떆�젒�냽�븷URL二쇱냼(�젅��寃쎈줈,�긽��寃쎈줈)"
		return mv;
	}
	
	// join  /member/join Get
	@RequestMapping(value = "join.iu", method = RequestMethod.GET)
	public String join() {
		
		return "member/join";
	}
	
	//Post
	@RequestMapping(value = "join.iu", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception {

		int result = bankMembersService.setJoin(bankMembersDTO, photo, session.getServletContext());

		
		return "redirect:./login.iu";
	}
	
	@RequestMapping(value="search.iu", method=RequestMethod.GET)
	public void getSearchByID()throws Exception{
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("member/search");
		//return mv;//"member/search";
	}
	
	@RequestMapping(value = "search.iu", method = RequestMethod.POST)
	public String getSearchByID(String search, Model model)throws Exception{
//		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		List<BankMembersDTO> ar= bankMembersService.getSearchByID(search);
		
		
		model.addAttribute("list", ar);
		return "member/list";
	}

}
