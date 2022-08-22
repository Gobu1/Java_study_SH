package com.iu.start.bankBook;

import java.util.List;

public interface BookDAO {

	public int delete(BankBookDTO bankBookDTO)throws Exception;
	
	public int setUpdate(BankBookDTO bankBookDTO)throws Exception;
	
	
	public int setBankBook(BankBookDTO bankBookDTO)throws Exception;
	
	
	public List<BankBookDTO> getList()throws Exception;	
	
	//어느 하나의 row의 Sale 컬럼 수정
	public int setChangeSale(BankBookDTO bankBookDTO)throws Exception;
	
	//BookNum의 값으로 조회
	public BankBookDTO getDetail(BankBookDTO bankBookDTO)throws Exception;

}
