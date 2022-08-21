package com.iu.start.bankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO implements BookDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankBook.BankBookDAO";
	
	
	@Override
	public int delete(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", bankBookDTO);
	}

	@Override
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}

	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setBankBook", bankBookDTO);
	}

	@Override
	public List<BankBookDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setChangeSale");
	}

	@Override
	public List<BankBookDTO> getDetail(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getDetail", bankBookDTO);
	}

}