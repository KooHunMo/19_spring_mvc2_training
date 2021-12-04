package com.spring.training.board_advance.service;

import java.util.List;
import java.util.Map;

import com.spring.training.board_advance.dto.BoardAdvanceDto;

public interface BoardAdvanceService {
	
	public List<BoardAdvanceDto> getSearchBoard(Map<String, Object> searchInfo) throws Exception;
				// List의 반환형 = BoardAdvanceDto
	// 질문: https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=50after&logNo=220886132591
	//	   : throws Exception 예외처리의 반환형을 써줘야 한다고 써있는데 없는 이유는??
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception;
	public BoardAdvanceDto getOneBoard(int num) throws Exception;
	public void insertBoard(BoardAdvanceDto bdto) throws Exception;
	public void insertReplyBoard(BoardAdvanceDto bdto) throws Exception;
	public boolean updateBoard(BoardAdvanceDto bdto) throws Exception;
	public boolean deleteBoard(BoardAdvanceDto bdto) throws Exception;
	public void makeDummyData() throws Exception;
	
}
