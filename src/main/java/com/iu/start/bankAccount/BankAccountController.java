package com.iu.start.bankAccount;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.bankMembers.BankMembersDTO;

@Controller
@RequestMapping(value = "/bankAccount/*")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO, HttpSession session)throws Exception{
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		bankAccountDTO.setUserName(bankMembersDTO.getUserName());
		System.out.println(bankMembersDTO.getUserName());
		//DTO : userName, bookNum
		int result = bankAccountService.setAddAccount(bankAccountDTO);
		
		return "redirect:../bankbook/list.iu";
	}

}
