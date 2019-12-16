package kakao.ahan447.FO.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kakao.ahan447.FO.DAO.SpringUserDAO;
import kakao.ahan447.FO.domain.SpringUser;

@Service
public class SpringUserServiceImpl implements SpringUserService {
	@Autowired
	private SpringUserDAO springUserDao;

	@Override
	public boolean emailCheck(String email) {
		boolean result = false;
		// email은 존재하지 않아야 중복검사를 통과
		String r = springUserDao.emailCheck(email);
		if (r == null) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean nicknameCheck(HttpServletRequest request) {
		boolean result = false;
		// 파라미터 읽기
		String nickname = request.getParameter("nickname");

		String r = springUserDao.nicknameCheck(nickname);

		if (r == null) {
			result = true;
		}

		return result;
	}

	@Override
	public void join(MultipartHttpServletRequest request) {
		// 파리미터 읽기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");

		String phone = request.getParameter("phone");
		// 체크박스의 값 가져와서 하나의 문자열 만들기
		String[] hobbies = request.getParameterValues("hobby");
		// 각각의 만자열에 ,를 추가
		String hobby = "";
		for (String temp : hobbies) {
			hobby = hobby + temp + ",";
		}
		// 마지막 , 는 제거
		hobby = hobby.substring(0, hobby.length() - 1);

		// 파일 이름 만들기와 업로드
		// file 파리미터의 값 가져오기
		MultipartFile f = request.getFile("image");
		// 원래 이름 가져오기
		String originName = f.getOriginalFilename();
		// 유일 무이한 이름 만들기
		String filename = email + originName;

		// 저장할 디렉토리 이름 만들기
		// 프로젝트 내의 경로
		// 실행하기 전에 프로젝트 내의 webapp(WebContent) 안에 디렉토리를 생성
		String path = request.getServletContext().getRealPath("/userimage");
		// 업로드하는 파일이 있으면 저장하고 그렇지 않으면 default.png 사용
		if (originName.length() > 0) {
			// 파일 업로드
			File file = new File(path + "/" + filename);
			try {
				f.transferTo(file);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}else {
			filename = "default.png";
		}
		
		
		// DAO 메소드 호출
		SpringUser user = new SpringUser();
		user.setEmail(email);
		//암호화해서 저장하기
		user.setPw(BCrypt.hashpw(pw,BCrypt.gensalt(10)));
		user.setName(name);
		user.setNickname(nickname);
		user.setPhone(phone);
		user.setHobby(hobby);
		user.setImage(filename);
		// 결과 리턴

		springUserDao.join(user);
	}

	@Override
	public boolean login(HttpServletRequest request) {
		boolean result = false;
		
		//파라미터 읽기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		//세션에서 로그인 정보를 가진 키의 값을 삭제
		request.getSession().removeAttribute("user");
		
		//email을 가지고 데이터를 가져오기
		SpringUser user = springUserDao.login(email);
		//email에 해당하는 데이터가 존재한다면
		if(user != null) {
			//비밀번호 비교
			if(BCrypt.checkpw(pw, user.getPw())) {
				//session의 user에 사용자 정보 저장
				user.setPw(null);
				request.getSession().setAttribute("user",user);
				//로그인 성공
				result = true;
			}
			
		}
		
		return result;
	}

}
