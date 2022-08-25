package com.iu.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar= qnaService.getList(pager);
		mv.addObject("board", "QNA");
		mv.addObject("list",ar);
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAdd()throws Exception{
		return "board/add";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setAdd(boardDTO);
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		mv.addObject("boardDTO",boardDTO);
		mv.setViewName("board/update");
		return mv;
	}

	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setUpdate(boardDTO);
		return "redirect:./detial.iu?num="+boardDTO.getNum();
	}
	
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setDelete(boardDTO);
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value = "reply.iu", method = RequestMethod.GET)
	public String setReply(BoardDTO boardDTO)throws Exception{
		return "board/reply";
	}
	
	@RequestMapping(value = "reply.iu", method = RequestMethod.POST)
	public String setReply(BoardDTO boardDTO, Model model)throws Exception{
		int result = qnaService.setReply(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "redirect:./detail.iu";
	}

}
