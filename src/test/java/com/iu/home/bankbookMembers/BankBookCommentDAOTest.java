package com.iu.home.bankbookMembers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyAbstractTest;
import com.iu.home.bankBook.BankBookCommentDAO;
import com.iu.home.bankBook.BankBookCommentDTO;

public class BankBookCommentDAOTest extends MyAbstractTest {

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void setCommentAdd() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(1L);
		bankBookCommentDTO.setWriter("asdas");
		bankBookCommentDTO.setContents("ffff");
		
		
		bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		
	}

}
