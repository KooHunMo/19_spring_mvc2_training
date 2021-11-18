package com.spring.training.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.training.board.dto.BoardDto;
import com.spring.training.board.service.BoardService;

@Controller // 컨트롤러임을 명시 (controller bean에 등록)
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/boardWrite" , method=RequestMethod.GET) //jsp파일을 리턴하기 때문에 String으로 지정된다. // value에는 url주소를 명시 , method는 요청 타입을 명시( 생략시 GET,POST 모두 처리 )
	public String boardWrite() {
		return "board/bWrite"; 		// servlet-context.xml에 명시된 대로 포워딩 시킬 jsp파일을 작성한다.
	}
	
	@RequestMapping(value="/boardWrite" , method=RequestMethod.POST) 
	public String boardWrite(BoardDto boardDto) {  // memberDto = setString(request.getPatameter("id"))등등 를 한번에 처리한다.
		System.out.println(boardDto);
		boardService.insertBoard(boardDto);
		
		//return "board/bList"; //순전히 jsp만 타기 때문에 리다이렉트로 이동시켜줘야 DB의 내용을 얻어온다.
		
		return "redirect:boardList"; // redirect:url 해당 url로 이동한다
	}
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET) //     /를 붙이면 앞에 .~ 하나가 url에서 사라짐
	public String boardList(Model model) {
		
		List<BoardDto> boardList = boardService.getBoardList();
		/*
		 * for (BoardDto boardDto : boardList) { System.out.println(boardDto); }
		 */
		// request.setAttribute("boardList", boardList);
		//mv.addObject("boardList", boardList);
		model.addAttribute("boardList", boardList);
		
		return "board/bList";
		
	}
	
	
	@RequestMapping(value="/boardInfo", method=RequestMethod.GET)
	public String boardInfo(@RequestParam("num") int num, Model model) { // getParameter안 써도 int num 하나로 BList의 ?num을 가져온다 //@RequestParam("num") 요청되는 것이 num인 것
		
		System.out.println(num); // 확인 이거 안댐
		
		BoardDto boardDto = boardService.getOneBoard(num);
		System.out.println(boardDto);
		model.addAttribute("boardDto", boardDto);
		return "board/bInfo";
		
		
		
	}
}
