package kakao.ahan447.FO;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kakao.ahan447.FO.domain.SpringUser;
import kakao.ahan447.FO.service.SpringUserMobileService;
import kakao.ahan447.FO.service.SpringUserService;

@RestController
public class JSONController {

	@Autowired
	private SpringUserService springUserService;
	// 이메일 중복감
	@RequestMapping(value="user/emailcheck",method=RequestMethod.GET)
	//email 이라는 파라미터를 email이라는 문자열 변수에 저장
	public Map<String, Object> emailCheck(
			@RequestParam("email") String email){
			//서비스 메소드 호출
			boolean result = springUserService.emailCheck(email);
			//결과 만들기
			Map<String, Object> map = new HashMap<String, Object>();
					map.put("result", result + "");
			//존재하는 email이면 result에 "false" 없는 email이면
			//result에 true가 저장
			return map;
			
			}
			
	//nicknamecheck 요청을 처리할 메소드
	//파라미터를 Service에 읽도록 했기 때문에 매개변수가
	//HttpServletRequest
	@RequestMapping
			(value="user/nicknamecheck",method=RequestMethod.GET)
	public Map<String, Object> nicknameCheck(
		HttpServletRequest request){
			boolean result =
					springUserService.nicknameCheck(request);
			Map<String, Object> map = new HashMap<String, Object>();
					map.put("result", result + "");
			//존재하는 email이면 result에 "false" 없는 email이면
			//result에 true가 저장
			return map;
		}
	@Autowired
	private SpringUserMobileService springUserMobileService;
	@RequestMapping(
			value="user/mobilelogin", method=RequestMethod.GET)
	public Map<String, Object> mobileLogin(
			HttpServletRequest request){
		//리턴할 Map 만들기
		Map<String, Object>map=
				new HashMap<String , Object>();
		//서비스 메소드 호출
		SpringUser user = springUserMobileService.login(request);
		if(user ==null) {
			map.put("result", "fail");
			}else{
				map.put("result", "success");
				map.put("user",user);
			}
		return map;
	}
	
			
			
	
}
