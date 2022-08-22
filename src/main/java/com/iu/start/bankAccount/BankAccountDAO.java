package com.iu.start.bankAccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.bankMembers.BankMembersDTO;

@Repository
public class BankAccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankAccount.BankAccountDAO.";
	
	public int add(BankAccountDTO bankAccountDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"add", bankAccountDTO);
	}
	
	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO)throws Exception{
		System.out.println(" ACCOUNT dao 실행");
		return sqlSession.selectList(NAMESPACE+"getListByUserName", bankMembersDTO);
	}
	
}
