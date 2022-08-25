package com.iu.start.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.getRowNum();
		Long totalCount=noticeDAO.getCount();

		pager.getNum(totalCount);
		
//		Long perPage=10L; //한 페이지에 출력할 목록의 개수
//		Long startRow=(page-1)*perPage+1;
//		Long lastRow=page*perPage;
//		
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		/*
//		 * jsp에 페이지번호를 출력 1 - ?
//		 * 1. 글의 총 갯수
//		 * 
//		 * 2. 총 페이지수 계산
//		 * 
//		 * 3. 글의 총 페이지수 계산
//		 * Block	: 
//		 * perBlock : 한페이지에 출력한 번호의 수
//		 * 
//		 * 4. page로 현재 Block 번호 찾기
//		 * page			curBlock
//		 * 1,2,3,4,5	1
//		 * 6,7,8,9,10	2
//		 * 
//		 * 5. curBlock로 시작번호와 끝번호 알아오기
//		 * curBlock		startNum	lastNum
//		 * 1			1			5
//		 * 2			6			10
//		 * 3			11			15
//		 */
//		
//		Long totalCount = noticeDAO.getCount();
//		
//		Long totalPage = totalCount/perPage;
//		if(totalCount%perPage != 0) {
//			totalPage++;  
//		}
//		
//		Long perBlock=5L;
//		Long totalBlock = totalPage/perBlock;
//		if(totalPage%perBlock != 0) {
//			totalBlock++;
//		}
//		
//		Long curBlock = page/perBlock;
//		if(page%perBlock !=0 ) {
//			curBlock++;
//		}
//		
//		Long startNum = (curBlock-1)*perBlock+1;
//		Long lastNum = curBlock*5;
//		
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
	
	@Override
	public Long getCount()throws Exception{
		return noticeDAO.getCount();
	}

}
