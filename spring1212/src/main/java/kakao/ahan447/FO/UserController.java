package kakao.ahan447.FO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	//user/login 이라는 요청이 온 경우 처리하는 메소드
	//단순한 페이지 이동만 수행
	@RequestMapping(
			value="user/join" , method=RequestMethod.GET)
	public String login(Model model) {
		return "user/join";
	}
}
