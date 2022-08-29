package com.iu.start.board.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.FileManager;
import com.iu.start.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileManager fileManager;
	
	
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
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception {
		int result = qnaDAO.setAdd(boardDTO);
		String path = "resources/upload/qna";
		for(MultipartFile multipartFile : files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String filename = fileManager.saveFile(path, servletContext, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(filename);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			qnaDAO.setAddFile(boardFileDTO);
			System.out.println("에드파일 실행후");
		}
		return result;
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
