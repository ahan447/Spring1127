package kakao.ahan447.FO.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kakao.ahan447.FO.DAO.SpringUserDAO;
import kakao.ahan447.FO.domain.SpringUser;

@Service
public class SpringUserMobileServiceImpl implements SpringUserMobileService {
	@Autowired
	private SpringUserDAO springUserDao;
	
	@Override
	public SpringUser login(HttpServletRequest request) {
		//파라미터 읽기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		//email을 이용해서 데이터 찾아오기
		SpringUser user = springUserDao.login(email);
		if(user != null) {
			if(BCrypt.checkpw(pw, user.getPw())) {
				user.setPw(null);
				return user;
			}
		}
		//로그인 실패한 경우에는 null를 리턴
		return null;
	}
	
	
	

}
