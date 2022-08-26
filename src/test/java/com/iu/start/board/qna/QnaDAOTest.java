package com.iu.start.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;

public class QnaDAOTest extends MyAbstractTest{
	
	@Autowired
	private QnaDAO qnaDAO;
	
//	@Test
//	public void getList()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		List<BoardDTO> ar = qnaDAO.getList();
//		assertEquals(0, ar.size());
//	}
//	@Test
//	public void setDelete()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(21L);
//		int result = qnaDAO.setDelete(boardDTO);
//		assertEquals(1, result);
//	}
	
	@Test
	public void setAdd()throws Exception{
		for(int i=0; i<100; i++) {
		QnaDTO qnaDTO = new QnaDTO();

		qnaDTO.setNum(1L);
		qnaDTO.setTitle("qna"+i);
		qnaDTO.setContents("addf"+i);
		qnaDTO.setWriter("qq"+i);
		int result = qnaDAO.setAdd(qnaDTO);
		if(i%10==0) {
			Thread.sleep(500);
		}
		}
	}
		
	
}
