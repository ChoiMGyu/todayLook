package Yeungnam.YU.service;
//비즈니스 계층

import Yeungnam.YU.model.Member;

public interface MemberService {
	
	public void join(Member member) throws Exception; //회원가입
	
	public Member login(Member member) throws Exception; //로그인
	
	public void update(Member member) throws Exception; //회원정보 수정
	
	public Member findMember(String login_id) throws Exception; //회원조회
	
	public int idChk(Member member) throws Exception; //아이디 중복체크
	
	public void memberDelete(Member member) throws Exception; //회원 탈퇴
}
