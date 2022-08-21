package com.iu.start.bankMembers;

import java.util.List;

public interface MembersDAO {
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception;
	
	public List<BankMembersDTO> getSearchByID(String search)throws Exception;
	
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception;
	
}
