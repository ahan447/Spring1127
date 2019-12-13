package kakao.ahan447.FO.service;

import javax.servlet.http.HttpServletRequest;

public interface SpringUserService {
	//서비스의 메소드는 파라미터를 Controller가 읽을 지
	//Service가 읽을 지에 따라서 메소드의 매개변수가 달라짐
	//Controller가 읽으면 변환된 파라미터가 매개변수이고
	//Service에서 읽고자 할 때는 HttpServletRequest임
	
	//이메일 중복 검사를 위한 메소드
	public boolean emailCheck(String email);
	
	//닉네임 중복검사를 위한 메소드
	public boolean nicknameCheck(HttpServletRequest request);
}
