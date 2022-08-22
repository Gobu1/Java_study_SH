package com.iu.start.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;

	
	public int delete(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.delete(bankBookDTO);
	}

	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setUpdate(bankBookDTO);
	}

	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setBankBook(bankBookDTO);
	}

	public List<BankBookDTO> getList() throws Exception {
		return bankBookDAO.getList();
	}

	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setChangeSale(bankBookDTO);
	}

	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getDetail(bankBookDTO);
	}
}
