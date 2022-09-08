package com.iu.home.bankbookMembers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyAbstractTest;
import com.iu.home.bankBook.BankBookCommentDAO;
import com.iu.home.bankBook.BankBookCommentDTO;
import com.iu.home.util.CommentPager;

public class BankBookCommentDAOTest extends MyAbstractTest {

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
//	@Test
//	public void setCommentAdd() throws Exception {
//		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
//		bankBookCommentDTO.setBookNum(1L);
//		bankBookCommentDTO.setWriter("asdas");
//		bankBookCommentDTO.setContents("ffff");
//		
//		
//		bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
//		
//	}
	
//	@Test
//	public void getCommentList()throws Exception{
//		CommentPager commentPager = new CommentPager();
//		commentPager.setBookNum(1662103891620L);
//		commentPager.getRowNum();
//		System.out.println(commentPager.getStartRow());
//		System.out.println(commentPager.getLastRow());
//		List<BankBookCommentDTO> ar =  bankBookCommentDAO.getCommentList(commentPager);
//		assertNotEquals(0, ar.size());
//	}
//	@Test
//	public void getCommentCount()throws Exception{
//		CommentPager commentPager = new CommentPager();
//		int result = bankBookCommentDAO.getCommnetCount(commentPager);
//		assertNotEquas(0, result);
//	}
	
	@Test
	public void setCommentUpdate()throws Exception{
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setNum(83L);
		bankBookCommentDTO.setWriter("213");
		bankBookCommentDTO.setContents("555");
		int result = bankBookCommentDAO.setCommentUpdate(bankBookCommentDTO);
		assertNotEquals(0, result);
	}

}
