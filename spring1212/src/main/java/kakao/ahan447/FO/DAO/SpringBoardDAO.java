package kakao.ahan447.FO.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kakao.ahan447.FO.domain.SpringBoard;

//필수
@Repository
public class SpringBoardDAO {
	@Autowired
	//xml을 이용한 MyBatis 사용
	private SqlSession	sqlSession;
	//인터페이스 이용한 MyBatis 사용할 때는 위의 구문 생략
	//하이버네티으를 사용할 때는 변경
	//private SessionFactory sessionFactory
	
	//가장 큰 글번호를 찾아오는 SQL 실행
	public Integer maxNum(){
		return sqlSession.selectOne("springboard.maxnum");
	}
	
	//글씨기를 위한 SQL
	public int write(SpringBoard board) {
			return sqlSession.insert("springboard.write" , board);
	}
	
	//목록보기를 위한 SQL 실행
	public List<SpringBoard> list(){
		return sqlSession.selectList("springboard.list");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
