package com.iu.home.bankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.home.util.CommentPager;

@Repository
public class BankBookCommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMEPSACE = "com.iu.home.bankBook.BankBookCommentDAO.";
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return sqlSession.insert(NAMEPSACE+"setCommentAdd", bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager)throws Exception{
		return sqlSession.selectList(NAMEPSACE+"getCommentList", commentPager);
	}

	
}
