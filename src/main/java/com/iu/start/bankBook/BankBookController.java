package com.iu.start.bankBook;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookService.delete(bankBookDTO);
		mv.setViewName("redirect:./list.iu");
		return mv;		
	}
	
	@RequestMapping(value = "update.iu", method=RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO)throws Exception{
		int result = bankBookService.setUpdate(bankBookDTO);
		
		return "redirect:./detail.iu?bookNum="+bankBookDTO.getBookNum();
		
	}
	
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model)throws Exception{
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	// /bankbook/add POST
	// name, rate
	@RequestMapping(value="add.iu", method=RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO)throws Exception{
		ModelAndView mv = new ModelAndView();

		Calendar ca = Calendar.getInstance();
		bankBookDTO.setBookNum(ca.getTimeInMillis());
		int result = bankBookService.setBankBook(bankBookDTO);
		
		//등록후 list 페이지로 이동
		mv.setViewName("redirect:./list.iu");
		
		return mv;
	}
	
	// /bankbook/add GET /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value="add.iu", method=RequestMethod.GET)
	public void add()throws Exception{
		System.out.println("add 실행");
		//return "bankbook/add";
	}
	
	@RequestMapping(value="list.iu", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		//ModelAndView mv = new ModelAndView();
		System.out.println("list 실행");
		//DB 없으신 분들
		List<BankBookDTO> ar = bankBookService.getList();

		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("detail 실행");
		
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		//return "bankbook/detail";
		//DB가 없으신 분들

		mv.setViewName("bankbook/detail");
		mv.addObject("dto", bankBookDTO);
		
		return mv;
	}
}
