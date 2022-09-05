package com.iu.home.bankMembers;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.bankAccount.BankAccountDAO;
import com.iu.home.bankAccount.BankAccountDTO;
import com.iu.home.util.FileManger;


@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private FileManger fileManger;
//	@Autowired
//	private ServletContext servletContext;
//	@Autowired
//	private BankAccountDAO bankAccountDAO;
	
//	public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO)throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>(); 
//		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//		map.put("list", ar);
//		map.put("dtp", bankMembersDTO);
//		 
//		return map; 
//	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		
		return bankMembersDAO.getLogin(bankMembersDTO);
	}

	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, ServletContext servletContext) throws Exception {
		System.out.println("체크1");
		int result =bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println("체크2");
		//1. HDD�뿉 �뙆�씪�쓣 ���옣
		//  �뙆�씪���옣�떆�뿉 寃쎈줈�뒗 Tomcat湲곗��씠 �븘�땲�씪 OS�쓽 湲곗��쑝濡� �꽕�젙
		// 1) �뙆�씪���옣 �쐞移�
		//    /resources/upload/member
		
//		// 2) ���옣�븷 �뤃�뜑�쓽 �떎�젣寃쎈줈 諛섑솚(OS 湲곗�)
//		String realPath = servletContext.getRealPath("resources/upload/member");
//		System.out.println("RealPath : "+realPath);
//		
//		// 3) ���옣�븷 �뤃�뜑�쓽 �젙蹂대�� 媛�吏��뒗 �옄諛� 媛앹껜 �깮�꽦
//		File file = new File(realPath);
//		
//		// *** File 泥⑤�媛� �뾾�쓣 �븣 援щ텇
//		
//		//if(photo.getSize()!=0) {}
//		if(!photo.isEmpty()) {
//		
//			if(!file.exists()) {
//				file.mkdirs();
//			}
//			
//			// 4) 以묐났�릺吏� �븡�뒗 �뙆�씪紐� �깮�꽦
//			//    -- �떆媛�, java api,...
//			// java api
//			String fileName = UUID.randomUUID().toString();
//			System.out.println(fileName);
//			
//			Calendar ca = Calendar.getInstance();
//			Long time = ca.getTimeInMillis();
//			
//			fileName = fileName+"_"+photo.getOriginalFilename();
//			System.out.println(fileName);
//			
//			//5. HDD�뿉 �뙆�씪 ���옣
//			// �뼱�뒓 �뤃�뜑�뿉 �뼱�뼡 �씠由꾩쑝濡� ���옣�븷 File 媛앹껜 �깮�꽦
//			file = new File(file, fileName);
//			
//			//  1) MutlipartFile �겢�옒�뒪�쓽 transferTo 硫붿꽌�뱶 �궗�슜
//			photo.transferTo(file);
			
			//  2) FileCopyUtils �겢�옒�뒪�쓽 copy 硫붿꽌�뱶 �궗�슜
			
			//2. ���옣�맂 �뙆�씪�젙蹂대�� DB�뿉 ���옣
		String path="resources/upload/member";
		String fileName = fileManger.saveFile(servletContext,path, photo);
		
			if(!photo.isEmpty()) {
				BankMembersFileDTO membersFileDTO = new BankMembersFileDTO();
				membersFileDTO.setFileName(fileName);
				membersFileDTO.setOriName(photo.getOriginalFilename());
				membersFileDTO.setUserName(bankMembersDTO.getUserName());
				bankMembersDAO.setAddFile(membersFileDTO);
			
			}//isEmpty �걹
		
		return result;
	}

	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		return bankMembersDAO.getSearchByID(search);
	}

}
