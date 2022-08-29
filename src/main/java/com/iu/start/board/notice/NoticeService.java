package com.iu.start.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
//	@Autowired
//	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.getRowNum();
		Long totalCount=noticeDAO.getCount(pager);
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
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception {
//		String realpath = servletContext.getRealPath("/resources/upload/notice");
		int result = noticeDAO.setAdd(boardDTO);
		String path = "resources/upload/notice";
		for(MultipartFile multipartFile : files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String filename = fileManager.saveFile(path, servletContext, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(filename);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
		
		
		}
//		File file = new File(realpath);
//		if(!file.exists()) {
//			file.mkdirs();
//		}
//		for(MultipartFile mf:files) {
//		if(mf.isEmpty()) {
//			continue;
//		}
//		file = new File(realpath);
////		Calendar ca = Calendar.getInstance();
////		Long time = ca.getTimeInMillis();
//		String filesname = UUID.randomUUID().toString();
//		System.out.println(mf.getOriginalFilename());
//		
//		filesname = filesname+"_"+mf.getOriginalFilename();
//		file = new File(file, filesname);
//		
//		System.out.println("확인"+file+filesname);
//		mf.transferTo(file);
//		
//		BoardFileDTO boardFileDTO = new BoardFileDTO();
//		boardFileDTO.setFileName(filesname);
//		boardFileDTO.setOriName(mf.getOriginalFilename());
//		boardFileDTO.setNum(boardDTO.getNum());
//		noticeDAO.setAddFile(boardFileDTO);
//		}
		

//		for(int i=0; i<files.length; i++) {
//			File file = new File(realpath);
//			if(!file.exists()) {
//				file.mkdirs();
//			}
//			if(files[i].isEmpty()) {	
//			}
//			Calendar ca = Calendar.getInstance();
//			Long time = ca.getTimeInMillis();
//			String filesname = time.toString();
//			System.out.println(files[i].getOriginalFilename());
//			
//			filesname = filesname+"_"+files[i].getOriginalFilename();
//			file = new File(file, filesname);
//			
//			System.out.println("확인"+file+filesname);
//			files[i].transferTo(file);
//			}
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
	
	

}
