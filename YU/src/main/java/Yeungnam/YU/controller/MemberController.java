package Yeungnam.YU.controller;
//프레젠테이션 계층

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Yeungnam.YU.model.Member;
import Yeungnam.YU.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller //@Controller + @ResponseBody = @RestController
@RequiredArgsConstructor
@RequestMapping("/members/*") //localhost:8080/members/로 연결
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private final MemberService memberService;
	
	@GetMapping("/new") //회원가입 폼으로 이동할 때는 GET 메서드
	//http://localhost:8080/members/signUp
	public String signUpForm() throws Exception
	{
		logger.info("get signup page"); //info : 프로그램 작동이 예상대로 진행되고 있는지 트래킹하기 위해 사용
		
		return "signup"; 
		//return View = signup.html
	}
	
	//이 함수에 대해서 다시 보기
	@PostMapping("/new") //회원가입 버튼을 눌렀을 때는 POST 메서드
	public String signUp(Member member) throws Exception
	{
		logger.info("post new member"); //log 남기기
		
		int result = memberService.idChk(member);
		try {
			if(result == 1)
				return "redirect:/members/new";
			else if(result == 0)
				memberService.join(member);
			//입력된 아이디가 존재한다면 회원가입 페이지로 다시 돌아가기
			//존재하지 않는다면 register
		} catch(Exception e) {
			throw new RuntimeException();
		} 
		
		return "redirect:/members/login"; //회원가입 후 로그인 페이지로 redirect
	}
	
	@ResponseBody //AJAX를 사용할 때 무조건 필요함
	@PostMapping("/idChk")
	public int idChk(Member member) throws Exception
	{
		//아이디 중복 검사
		int result = memberService.idChk(member);
		return result;
	}
	
	@GetMapping("/memberUpdateView")
	public String joinUpdateView() throws Exception
	{
		return "member/memberUpdateView";
	}
	
	@PostMapping("/memberUpdate")
	public String joinUpdate(Member member, HttpSession session) throws Exception
	{
		memberService.update(member);
		
		session.invalidate();
		//세션을 무효화, 해당 세션과 관련된 모든 데이터가 삭제되고,
		//새로운 세션을 생성해야 다시 데이터를 저장할 수 있음
		
		return "redirect:/";
	}
	
	@PostMapping("/memberDelete")
	public String memberDelete(Member member, HttpSession session, RedirectAttributes rttr) throws Exception
	{
		//세션에 있는 member를 가져와 member vo 변수에 넣어줍니다.
		//addFlashAttribue로 저장되었을 경우 getAttribute()로 가져옴
		Member vo = (Member)session.getAttribute("member");
		//세션에 있는 비밀번호
		String sessionPass = vo.getPassword();
		//member로 들어오는 비밀번호
		String memberPass = member.getPassword();
		
		if(!(sessionPass.equals(memberPass)))
		{
			rttr.addFlashAttribute("msg", false);
			//검증여부, 실패여부 메세지를 만들 때 addFlashAttribute() 사용 
			return "redirect:/members/memberDeleteView";
		}
		memberService.memberDelete(member);
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/findid")
	public String findId()
	{
		logger.info("get findId");
		
		return "findId";
	}
	
	@GetMapping("/findpw")
	public String findPw()
	{
		logger.info("get findPw");
		
		return "findPw";
	}
	
//	@PostMapping("/main")
//	public String main()
//	{
//		logger.info("post main");
//		
//		return "main";
//	}
}
