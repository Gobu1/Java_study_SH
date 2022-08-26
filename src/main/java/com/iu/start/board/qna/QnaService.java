package com.iu.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	
	public int setReply(QnaDTO qnaDTO) throws Exception {
		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
		
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		qnaDAO.setStepUpdate(parent);
		
		return qnaDAO.setReply(qnaDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.getRowNum();
		Long totalCount=qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		return qnaDAO.getList(pager);
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
	


}
