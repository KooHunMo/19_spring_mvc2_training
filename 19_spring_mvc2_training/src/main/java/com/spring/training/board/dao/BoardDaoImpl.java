package com.spring.training.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.training.board.dto.BoardDto;


@Repository // DAO(Data Access Object) 데이터 접근 객체는 @Repository를 명시해야 한다
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlsession; // DB연결 정보 불러옴 - ioC사용 
	
	@Override
	public void insert(BoardDto boardDto) {
		System.out.println("----DAO----");
		System.out.println(boardDto);
	}

}
