package com.spring.training.board.service;

import java.util.List;

import com.spring.training.board.dto.BoardDto;

public interface BoardService {

	public void insertBoard(BoardDto boardDto);
	
	public List<BoardDto> getBoardList();
	
	public BoardDto getOneBoard(int num);
	
	public boolean deleteBoard(BoardDto boardDto); //체크하는건 boolean 돌아가는건 BoardDto
}
