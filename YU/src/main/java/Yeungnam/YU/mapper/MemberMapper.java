package Yeungnam.YU.mapper;
//데이터 접근 계층

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import Yeungnam.YU.model.Member;

//@Component
@Mapper //mapper 등록을 위한 인터페이스에 사용
public interface MemberMapper {
	//DB에 접근해야하는 메소드들을 나열(DAO의 역할을 대신함)
	//TestMapper.xml에 id를 메소드명으로하여 SQL 구문 작성
	
	public void join(Member member) throws Exception; //회원정보 저장

	public Member findMember(String login_id) throws Exception; //회원정보 조회
	
	public Member login(Member member) throws Exception; //로그인 데이터베이스 접근
	
	public void update(Member member) throws Exception; //회원정보 수정
	
	public int idChk(Member member) throws Exception; //아이디 중복체크
	
	public void memberDelete(Member member) throws Exception; //회원탈퇴
 
}
