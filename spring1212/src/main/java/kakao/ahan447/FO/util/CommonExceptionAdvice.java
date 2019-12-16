package kakao.ahan447.FO.util;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
//kakao.ahan447.FO 패키지에서 예외가 발생하면
//에러 페이지를 지정해주는 어노테이션
@ControllerAdvice("kakao.ahan447.FO")
public class CommonExceptionAdvice {
	@ExceptionHandler(Exception.class)
	public String errorPage(Model model) {
		//예외 찾기
		//model.addAttribute("error", e.getMessage());
		//error 디렉토리에 error.jsp 파일을 에러 페이지로 설정
		return "/error/error";
	}
}
