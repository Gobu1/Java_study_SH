package com.iu.start.board.impl;

import java.util.List;
import java.util.Map;


public interface BoardDAO {
	
	public List<BoardDTO> getList(Map<String, Long> map)throws Exception;
	
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	
	public int setAdd(BoardDTO boardDTO)throws Exception;
	
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	public int setDelete(BoardDTO boardDTO)throws Exception;
	
	public Long getCount()throws Exception;
} 
