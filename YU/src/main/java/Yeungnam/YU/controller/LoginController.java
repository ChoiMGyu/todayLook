package Yeungnam.YU.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Yeungnam.YU.model.Member;
import Yeungnam.YU.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members/*")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private final MemberService memberService;
	
	@GetMapping("/login")
	public String loginForm()
	{
		logger.info("get login");
		
		return "login";
	}

	@PostMapping("/login")
	public String login(Member member, HttpServletRequest req, RedirectAttributes rttr) throws Exception
	{
		logger.info("post login");
		
		HttpSession session = req.getSession(); //httpsession 객체 얻기
		//http는 상태를 유지하지 않는 stateless 프로토콜
		//로그인 구현에서는 클라이언트와 서버 간의 상태 정보를 유지해야함 -> 세션 기술 제공(HttpSession)
		Member login = memberService.login(member);
		
		if(login == null)
		{
			logger.info("login failed!");
			session.setAttribute("member", null); //session member에 null값을 저장
			rttr.addFlashAttribute("msg", false);
			return "redirect:/members/login";
		}
		else
		{
			logger.info("login successed!");
			session.setAttribute("member", login);
			return "redirect:/members/main";
			//redirect -> 주소가 바뀌고 해당 URL에 속하는 컨트롤러의 함수가 한번 더 호출됨
		}
		
		//return "redirect:/members/main";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception
	{
		logger.info("get logout");
		
		session.invalidate();
		//세션을 무효화, 해당 세션과 관련된 모든 데이터가 삭제되고,
		//새로운 세션을 생성해야 다시 데이터를 저장할 수 있음
		
		return "redirect:/"; //로그인페이지로 redirect 
	}
}
