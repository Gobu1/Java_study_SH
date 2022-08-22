package com.iu.start.bankBook;

import java.util.List;

import com.iu.start.bankAccount.BankAccountDTO;

public class BankBookDTO {
	
	private Long bookNum;
	private String bookName;
	private Long bookRate;
	private Long bookSale;
	private String bookContents;
	private List<BankAccountDTO> bankAccountDTOs;
	
	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}
	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}
	
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Long getBookRate() {
		return bookRate;
	}
	public void setBookRate(Long bookRate) {
		this.bookRate = bookRate;
	}
	public Long getBookSale() {
		return bookSale;
	}
	public void setBookSale(Long bookSale) {
		this.bookSale = bookSale;
	}
	public String getBookContents() {
		return bookContents;
	}
	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}
	
	
}
