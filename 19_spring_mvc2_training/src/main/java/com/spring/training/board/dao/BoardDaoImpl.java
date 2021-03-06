package com.spring.training.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.training.board.dto.BoardDto;


@Repository // DAO(Data Access Object) 데이터 접근 객체는 @Repository를 명시해야 한다
public class BoardDaoImpl implements BoardDao {

	@Autowired // sqlSession 객체 생성
	private SqlSession sqlSession; // DB연결 정보 불러옴 - ioC사용 
	
	@Override
	public void insert(BoardDto boardDto) {

					          // (namespace명.쿼리id명    , 파라메타)
		sqlSession.insert("mapper.BoardMapper.insertBoard", boardDto); //mapper.BoardMapper.insertBoard 여기에 boardDto를 넣는다
	}

	@Override
	public List<BoardDto> selectAll() {
		
		return sqlSession.selectList("mapper.BoardMapper.getAllBoard"); // 모든 쿼리문이 여기 담겨있음 리턴으로 올린다
			// sqlSession.selectOne(statement); 두종류가 있음/ 한줄만 받을 때 사용
		
		
	}

	@Override
	public BoardDto selectOne(int num) {
		return sqlSession.selectOne("mapper.BoardMapper.getOneBoard", num); // num을 넘겨준다
	}

	@Override
	public BoardDto validateUserCheck(BoardDto boardDto) {
	
		return sqlSession.selectOne("mapper.BoardMapper.validateUserCheck", boardDto);
	}

	@Override
	public void delete(int num) {
		sqlSession.delete("mapper.BoardMapper.deleteBoard", num);
		
	}

	@Override
	public void update(BoardDto boardDto) {
		sqlSession.update("mapper.BoardMapper.updateBoard", boardDto);
		
	}

	@Override
	public void increaseReadCount(int num) {
		sqlSession.update("mapper.BoardMapper.increaseReadCount", num);
		
	}

}
