package com.iu.start.bankMembers;

import java.util.List;

import com.iu.start.bankAccount.BankAccountDTO;

public class BankMembersDTO {
	private String userName;
	private String password;
	private String name;
	private String email;
	private String phone;
	private List<BankAccountDTO> bankAccountDTOs;
	private BankMembersFileDTO bankMembersFileDTOs;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}
	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}
	public BankMembersFileDTO getBankMembersFileDTOs() {
		return bankMembersFileDTOs;
	}
	public void setBankMembersFileDTOs(BankMembersFileDTO bankMembersFileDTOs) {
		this.bankMembersFileDTOs = bankMembersFileDTOs;
	}
	
	
	
	

	
	
	
	}
	

