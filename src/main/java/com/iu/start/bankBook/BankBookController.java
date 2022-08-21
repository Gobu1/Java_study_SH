package com.iu.start.bankBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	

}
