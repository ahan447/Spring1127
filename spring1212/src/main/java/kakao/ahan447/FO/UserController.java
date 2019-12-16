package kakao.ahan447.FO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kakao.ahan447.FO.service.SpringUserService;

@Controller
public class UserController {
	//user/login 이라는 요청이 온 경우 처리하는 메소드
	//단순한 페이지 이동만 수행
	@RequestMapping(
			value="user/join" , method=RequestMethod.GET)
	public String join(Model model) {
		return "user/join";
	}
	
	@Autowired
	private SpringUserService userService;
	
	//회원가입 처리를 위한 메소드
	//RedirectAttributes 는 스프링이 제공하는 1회용 데이터 저장 클래스
	//redirect 할 때 한번만 사용하고자 하는 데이터가 있을 때 사용
	//주로 메시지 저장할 때 사용
	@RequestMapping(
			value="user/join" , method=RequestMethod.POST)
	public String join(MultipartHttpServletRequest request,
			RedirectAttributes attr) {
		//서비스의 메소드 호출
		userService.join(request);
		//데이터 저장 -1회용
		attr.addFlashAttribute("msg", "회원가입 성공");
		//login 으로 리다이렉트
		return "redirect:login";
	}
	
	//로그인 페이지로 이동 하는 메소드
	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public String login(Model model) {
		return "user/login";
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public String login(Model model, 
			HttpServletRequest request,
			RedirectAttributes attr) {
		//서비스 메소드 호출
		boolean result = userService.login(request);
		if(result == true) {
			//메인 페이지로 리다이렉트
			return "redirect:/";
		}else {
			//로그인 페이지로 이동
			attr.addFlashAttribute("msg" , "없는 아이디이거나 틀린 비밀번호");
			return "redirect:/user/login";
			
			
		}
	}
	
	@RequestMapping(value="user/logout", method=RequestMethod.GET)
	public String logout(HttpSession session ,RedirectAttributes attr) {
		//로그아웃 처리 - 세션을 초기화해도 되고 세션에서 user만 초기화해도 됨
		
		//session.invalidate();
		session.removeAttribute("user");
		attr.addFlashAttribute("msg", "로그아웃 완료");
		return "redirect:/";
	}
	
	
}
