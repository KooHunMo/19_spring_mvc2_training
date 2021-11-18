package com.spring.training.board.dao;

import java.util.List;

import com.spring.training.board.dto.BoardDto;

public interface BoardDao {

	public void insert(BoardDto boardDto);
	public List<BoardDto> selectAll();   // list는 arraylist와 같다
	public BoardDto selectOne(int num);  //BoardDto 서비스단으로 넘어가는 반환타입 int num은 매퍼로 넘어가는 BoardDto를 담는 변수
}
