package com.spring.training.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.training.board.dto.BoardDto;


@Repository // DAO(Data Access Object) 데이터 접근 객체는 @Repository를 명시해야 한다
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession; // DB연결 정보 불러옴 - ioC사용 
	
	@Override
	public void insert(BoardDto boardDto) {

					  // (namespace명.쿼리id명, 파라메타)
		sqlSession.insert("mapper.BoardMapper.insertBoard", boardDto); //mapper.BoardMapper.insertBoard 여기에 boardDto를 넣는다
	}

	@Override
	public List<BoardDto> selectAll() {
		
		return sqlSession.selectList("mapper.BoardMapper.getAllBoard"); // 모든 쿼리문이 여기 담겨있음 리턴으로 올린다
			// sqlSession.selectOne(statement); 두종류가 있음
		
		
	}

}
