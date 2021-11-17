package com.spring.training.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.training.board.dao.BoardDao;
import com.spring.training.board.dto.BoardDto;

@Service // 서비스(비즈니스 로직)은 @Service를 명시해야 한다. (service bean으로 등록)
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao BoardDao;
	
	@Override
	public void insertBoard(BoardDto boardDto) {
		
		System.out.println("----service---");
		BoardDao.insert(boardDto);
	}
	
}
