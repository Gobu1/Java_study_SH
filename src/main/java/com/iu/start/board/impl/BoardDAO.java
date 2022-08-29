package com.iu.start.board.impl;

import java.util.List;
import java.util.Map;

import com.iu.start.util.Pager;


public interface BoardDAO {
	
	public int setAddFile(BoardFileDTO boardFileDTO)throws Exception;
	
	public List<BoardDTO> getList(Pager pager)throws Exception;
	
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	
	public int setAdd(BoardDTO boardDTO)throws Exception;
	
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	public int setDelete(BoardDTO boardDTO)throws Exception;
	
	public Long getCount(Pager pager)throws Exception;
} 
