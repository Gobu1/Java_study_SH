package com.iu.start.bankAccount;

import java.util.Date;

import com.iu.start.bankBook.BankBookDTO;

public class BankAccountDTO {
	private Long accountNum;
	private String userName;
	private Long bookNum;
	private Date accountDate;
	private BankBookDTO bankBookDTO;
	
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long account) {
		this.accountNum = account;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	
	public BankBookDTO getBankBookDTO() {
		return bankBookDTO;
	}
	public void setBankBookDTO(BankBookDTO bankBookDTO) {
		this.bankBookDTO = bankBookDTO;
	}

	
}
