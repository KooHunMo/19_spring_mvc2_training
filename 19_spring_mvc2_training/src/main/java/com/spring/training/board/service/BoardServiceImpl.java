package com.spring.training.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.training.board.dao.BoardDao;
import com.spring.training.board.dto.BoardDto;

@Service // 서비스(비즈니스 로직)은 @Service를 명시해야 한다. (service bean으로 등록)
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public void insertBoard(BoardDto boardDto) {
		boardDao.insert(boardDto);
	}

	@Override
	public List<BoardDto> getBoardList() {
		return boardDao.selectAll();
		
	}

	@Override
	public BoardDto getOneBoard(int num) {
		
		//조회수를 올리는 dao
		boardDao.increaseReadCount(num);
		
		return boardDao.selectOne(num);
	}

	@Override
	public boolean deleteBoard(BoardDto boardDto) {
		boolean isSucceed = false;
		
		if(boardDao.validateUserCheck(boardDto) != null) {
			boardDao.delete(boardDto.getNum());
			isSucceed = true;
		}
		
		return isSucceed;
	}

	@Override
	public boolean updateBoard(BoardDto boardDto) {
		boolean isSucceed = false;
		
		if(boardDao.validateUserCheck(boardDto) != null) {
			boardDao.update(boardDto); // num만 보내는게 아니라 다 보내는것이기 때문에 boardDto를 사용한다
			isSucceed = true;
		}
		return isSucceed;
	}
	
}
