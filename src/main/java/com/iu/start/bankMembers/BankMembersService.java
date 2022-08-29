package com.iu.start.bankMembers;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.util.FileManager;


@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private FileManager fileManager;
//	@Autowired
//	private ServletContext servletContext;
//	@Autowired
//	private BankAccountDAO bankAccountDAO;
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception {
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	public List<BankMembersDTO> getSearchByID(String search)throws Exception{
		return bankMembersDAO.getSearchByID(search);
	}
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, ServletContext servletContext)throws Exception{
		int result =  bankMembersDAO.setJoin(bankMembersDTO);
		String path = "resources/upload/notice";
	
		fileManager.saveFile(path, servletContext, photo);
		BankMembersFileDTO membersFileDTO = new BankMembersFileDTO();
		membersFileDTO.setFileName(path);
		membersFileDTO.setOriName(photo.getOriginalFilename());
		membersFileDTO.setUserName(bankMembersDTO.getUserName());
		bankMembersDAO.setAddFile(membersFileDTO);
		
		
		
		
//		//1. HDD 파일을 저장 - 파일저장시 경로는 Tomcat기준이 아닌 OS의 기준으로 설정
//		//1) 파일저장위치 /resources/upload/member
//		//2) 저장할 폴더의 실제경로 반환(OS 기준)
//		String realpath = servletContext.getRealPath("/resources/upload/member");
//		System.out.println(realpath);
//		//3) 저장할 폴더의 정보를 가지는 자바 객체 생성
//		File file = new File(realpath);
//		if(!file.exists()) {
//			file.mkdirs(); 
//		}
//		//**file 첨부가 없을시
////		if(photo.getSize() != 0) {}
//		if(photo.isEmpty()) {
//			
//		}
//		
//		//4) 중복되지 않는 파일명 생성
//		//	-- 시간, java apl,..
//		String filename = UUID.randomUUID().toString();
//		 System.out.println(filename);
//		Calendar ca = Calendar.getInstance();
//		Long time = ca.getTimeInMillis();//time 랜덤
//		
//		filename = filename+"_"+photo.getOriginalFilename();
//		System.out.println(filename);
//		//5) HDD에 파일 저장
//		// 어느 폴더에 어떤 이름으로 저장할 File 객체
//		file = new File(file, filename);
//		// 5-1) MultipartFile 클래스의 transferTo 메서드 사용
//		photo.transferTo(file);
//		// 5-2) FileCopyUtils 클래스의 copy 메서드 사용
//		 
//		//2. 저장된 파일정보를 DB에 저장
//		BankMembersFileDTO membersFileDTO = new BankMembersFileDTO();
//		membersFileDTO.setFileName(filename);
//		membersFileDTO.setOriName(photo.getOriginalFilename());
//		membersFileDTO.setUserName(bankMembersDTO.getUserName());
//		bankMembersDAO.setAddFile(membersFileDTO);
		
		return result;
	}
	
}
