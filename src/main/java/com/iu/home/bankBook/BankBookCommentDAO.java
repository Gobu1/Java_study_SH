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
	
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return sqlSession.update(NAMEPSACE+"setCommentUpdate", bankBookCommentDTO);
	}
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return sqlSession.insert(NAMEPSACE+"setCommentAdd", bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager)throws Exception{
		return sqlSession.selectList(NAMEPSACE+"getCommentList", commentPager);
	}

	public Long getCommentCount(CommentPager commentPager)throws Exception {
		return sqlSession.selectOne(NAMEPSACE+"getCommentCount", commentPager);
	}
	
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		System.out.println(bankBookCommentDTO.getNum());
		return sqlSession.delete(NAMEPSACE+"setCommentDelete", bankBookCommentDTO);
	}
}
