package com.spring.training.board.dao;

import java.util.List;

import com.spring.training.board.dto.BoardDto;

public interface BoardDao {

	public void insert(BoardDto boardDto);
	public List<BoardDto> selectAll();   // list는 arraylist와 같다
	public BoardDto selectOne(int num);  //BoardDto 서비스단으로 넘어가는 반환타입 int num은 매퍼로 넘어가는 BoardDto를 담는 변수
	public BoardDto validateUserCheck(BoardDto boardDto); //체크하는데는 boardDto가 필요함
	public void delete(int num); // 지우는데는 num하나만 필요하기 때문
	public void update(BoardDto boardDto);
	public void increaseReadCount(int num);
}
