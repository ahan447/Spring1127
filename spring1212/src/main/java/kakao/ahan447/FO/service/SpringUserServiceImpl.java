package kakao.ahan447.FO.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kakao.ahan447.FO.DAO.SpringUserDAO;

@Service
public class SpringUserServiceImpl implements SpringUserService {
	@Autowired
	private SpringUserDAO springUserDao;
	
	@Override
	public boolean emailCheck(String email) {
		boolean result = false;
		//email은 존재하지 않아야 중복검사를 통과
		String r = springUserDao.emailCheck(email);
		if(r == null) {
			result = true;
		}
		
		return result;
	}

	@Override
	public boolean nicknameCheck(HttpServletRequest request) {
		boolean result = false;
		//파라미터 읽기
		String nickname = request.getParameter("nickname");
		
		String r = springUserDao.nicknameCheck(nickname);
		
		if(r == null) {
			result = true;
		}
		
		return result;
	}

}
