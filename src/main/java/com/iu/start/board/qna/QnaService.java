package com.iu.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> getList(Long page) throws Exception {
		return qnaDAO.getList(null);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}
	
	public int setReply(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setReply(boardDTO);
	}

	@Override
	public Long getCount() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
