package com.spring.training.member.service;

import java.util.List;

import com.spring.training.member.dto.MemberDto;

public interface MemberService {

	public void joinMember(MemberDto memberDto) throws Exception;	// throws Exception은 에러를 호출한 메서드에게 error를 전가하는 것
	public MemberDto loginMember(MemberDto memberDto) throws Exception; // try, catch를 넘겨준쪽에서 해라 라는 뜻
	public List<MemberDto> showAllMember() throws Exception;
	public MemberDto showOneMember(String memberId) throws Exception;
	public boolean updateMember(MemberDto memberDto) throws Exception;
	public boolean deleteMember(MemberDto memberDto) throws Exception;
	public String overlapped(String memberId) throws Exception; 
	
}
