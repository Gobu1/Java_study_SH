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
	
	@Test
	public void getList()throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		List<BoardDTO> ar = noticeDAO.getList();
		assertEquals(0, ar.size());
	}
	
	
//	@Test
//	public void getDetail()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(123L);
//		boardDTO = noticeDAO.getDetail(boardDTO);
//		assertNull(boardDTO);
//	}
	
//	@Test
//	public void setAdd()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		Date date = new Date();
//		boardDTO.setNum(1L);
//		boardDTO.setTitle("asd");
//		boardDTO.setContents("dd");
//		boardDTO.setWriter("dd");
//		boardDTO.setRegDate(date);
//		boardDTO.setHit(13L);
//		int result = noticeDAO.setAdd(boardDTO);
//		assertEquals(1, result);
//	}
	
	

}
