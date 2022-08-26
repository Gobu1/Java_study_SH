package com.iu.start.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.notice.NoticeDAO;
import com.iu.start.MyAbstractTest;

public class NoticeDAOTest extends MyAbstractTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void getList()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		List<BoardDTO> ar = noticeDAO.getList();
//		assertEquals(0, ar.size());
//	}
	
	
//	@Test
//	public void getDetail()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(123L);
//		boardDTO = noticeDAO.getDetail(boardDTO);
//		assertNull(boardDTO);
//	}
	
	@Test
	public void setAdd()throws Exception{
		for(int i=0; i<100; i++) {
		BoardDTO boardDTO = new BoardDTO();

		boardDTO.setNum(1L);
		boardDTO.setTitle("asd"+i);
		boardDTO.setContents("dd"+i);
		boardDTO.setWriter("dd"+i);
		int result = noticeDAO.setAdd(boardDTO);
		if(i%10==0) {
			Thread.sleep(500);
		}
		}
	}
	
	
		
	
	
	

}
