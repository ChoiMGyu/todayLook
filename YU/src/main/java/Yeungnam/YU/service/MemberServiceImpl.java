package Yeungnam.YU.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Yeungnam.YU.mapper.MemberMapper;
import Yeungnam.YU.model.Member;
import lombok.RequiredArgsConstructor;

@Service
//Service에 구현된 메소드명과 mapper에 구현된 메소드명이 동일할 수 있음
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    
	private final MemberMapper memberMapper;
	
	//private final SqlSessionTemplate sql;
	//@inject와 final + requiredArgsConstructor은 차이 x => 취향 차이
	
	@Override
	public void join(Member member) throws Exception {
		memberMapper.join(member);
	}
	
	@Override
	public Member findMember(String login_id) throws Exception{
		Member member = memberMapper.findMember(login_id);
		return member;
	}

	@Override
	@Transactional
	//모든 메소드가 정상적으로 실행되어야 commit, 하나 이상 실패하게 된다면 Rollback 처리
	public Member login(Member member) throws Exception {
		Member lg_member = memberMapper.login(member);
		return lg_member;
		//sqlsessiontemplate으로 MemberMapper.xml의 login을 실행하는 데,
		//parameter로 member 객체를 넘겨줌
		//sqlsessiontemplate을 사용하면 sqlsession의 생성과 관리에 대한 부분을 자동으로 처리
	}

	@Override
	public void update(Member member) throws Exception {
		memberMapper.update(member);
	}

	@Override
	@Transactional
	//모든 메소드가 정상적으로 실행되어야 commit, 하나 이상 실패하게 된다면 Rollback 처리
	public int idChk(Member member) throws Exception {
		int result = memberMapper.idChk(member);
		return result;
	}

	@Override
	public void memberDelete(Member member) throws Exception {
		memberMapper.memberDelete(member);
	}
	
}
