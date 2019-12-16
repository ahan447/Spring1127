package kakao.ahan447.FO.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kakao.ahan447.FO.domain.SpringUser;

//bean을 자동 생성해주는 어노테이션
//데이터베이스 작업을 해주는 클래스라는 의미를 전달하기 위해서
//@Component 대신에 @Repository라고 작성 
@Repository
public class SpringUserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//email 중복검사를 위한 메소드
	public String emailCheck(String email) {
		return sqlSession.selectOne(
				"springuser.emailCheck",email);
	}
	
	//nickname 중복검사를 위한 메소드
	public String nicknameCheck(String nickname) {
	return sqlSession.selectOne(
			"springuser.nicknameCheck",nickname);
	}
	
	//회원 가입을 위한 메소드
	public int join(SpringUser springUser) {
		return sqlSession.insert("springuser.join", springUser);
	}
			
	//로그인 처리를 위한 메소드
	public SpringUser login(String email){
	return sqlSession.selectOne("springuser.login",email);
}	
	
}
