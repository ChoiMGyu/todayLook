package Yeungnam.YU.join;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import Yeungnam.YU.mapper.MemberMapper;
import Yeungnam.YU.model.Member;
import Yeungnam.YU.service.MemberService;
import lombok.RequiredArgsConstructor;

//@ExtendWith(SpringExtension.class) //JUnit5 사용 시 작성
//@MybatisTest
@SpringBootTest
//@SpringBootTest가 @MybatisTest의 상위 호환이라고 생각하면 됨
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//실 데이터베이스에 연결 시 필요한 어노테이션
@RequiredArgsConstructor
public class JoinTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(JoinTest.class);	
	
	@Test
	@DisplayName("회원가입 테스트")
	public void 회원가입() throws Exception 
	{
		//given
		Member member = new Member("login_id", "password", "emailx", "email_select", "nicknamex", "department", "department_select", 0, "010", "memberPhone");
		
		//when
		//memberMapper.join(member);
		Member findMember = memberService.findMember(member.getLogin_id());
		
		//then
		Assertions.assertThat(findMember.getLogin_id()).isEqualTo(member.getLogin_id());
	}
	
	@Test
	@DisplayName("회원가입(중복아이디) 테스트")
    public void 회원가입_중복아이디() throws Exception 
	{
		//given : 이러한 환경이 주어졌을 때
		Member member = new Member("idmini", "password", "emailx", "email_select", "nicknamex", "department", "department_select", 0, "010", "memberPhone");
		
		//when : 이런 동작을 하면
		int result = memberMapper.idChk(member); //중복된 아이디의 경우 1을 반환
		
		//then : 이런 결과가 주어진다
		Assertions.assertThat(result).isEqualTo(1);
    }
	
	@Test
	@DisplayName("회원가입(비밀번호확인) 테스트")
	public void 회원가입_비밀번호확인() throws Exception
	{
		
	}
	
	@Test
	@DisplayName("로그인 기능 테스트")
	public void 로그인() throws Exception
	{
		//given
		Member member = new Member("idmini", "password", "email", "email_select", "nicknamex", "department", "department_select", 0, "010", "memberPhone");
		
		//when
		Member loginMember = memberMapper.login(member);
		
		//then
		Assertions.assertThat(member.getPassword()).isEqualTo(loginMember.getPassword());
	}
	
	@Test
	@DisplayName("회원정보 수정 테스트")
	public void 회원정보_수정() throws Exception
	{
		//given
		//Member newMember = new Member(
		//		"idmini", "passwordnew", "emailx", "email_select", "nicknameNew",
		//		"department", "department_select", 0, "010", "memberPhone");
		Member findMember = memberMapper.findMember("idmini");
		
		//when
		memberMapper.update(findMember);
		
		//then
		//Member findMember = memberMapper.findMember("idmini");
		//Assertions.assertThat(findMember.getPassword()).isEqualTo(newMember.getPassword());
	}
	
	@Test
	@DisplayName("회원탈퇴 테스트")
	public void 회원탈퇴() throws Exception
	{
		//given
		Member member = new Member("idsmall", "passwordlong", "emailx", "email_select", "nicknamex", "department", "department_select", 0, "010", "12345678");
		
		//when
		memberMapper.memberDelete(member);
		
		//then
		Member findMember = memberMapper.findMember("idsmall");
		Assertions.assertThat(findMember).isEqualTo(null);
	}
}
