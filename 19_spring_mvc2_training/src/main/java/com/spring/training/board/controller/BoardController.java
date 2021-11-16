package com.spring.training.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 컨트롤러임을 명시 (controller bean에 등록)
public class BoardController {

	@RequestMapping(value="/boardWrite" , method=RequestMethod.GET)
	public String boardWrite() {  //jsp파일을 리턴하기 때문에 String으로 지정된다.
		return "board/bWrite";
	}
	
	
}
