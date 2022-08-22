package com.iu.start.bankAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.bankMembers.BankMembersDTO;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO) throws Exception{
		System.out.println("ACCOUNT 서비스 실행");
		return bankAccountDAO.getListByUserName(bankMembersDTO);
	}
}