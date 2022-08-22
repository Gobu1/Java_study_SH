package com.iu.start.bankMembers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;


@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception {
		System.out.println("멤버 서비스 실행");
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	public List<BankMembersDTO> getSearchByID(String search)throws Exception{
		return bankMembersDAO.getSearchByID(search);
	}
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.setJoin(bankMembersDTO);
	}
	
}
