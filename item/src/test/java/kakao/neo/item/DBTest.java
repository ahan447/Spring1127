package kakao.neo.item;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kakao.neo.item.domain.dao.ItemDao;

//스프링에서 설정 파일(xml)을 이용하는 경우의 테스트 클래스
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {
				
				
				"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		//			
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class DBTest {
	//MyBatis 연동 개체를 주입
	@Autowired
	private SqlSession sqlSession;
	
	//ItemDao를 주입
	@Autowired
	private ItemDao itemDao;
	
	@Test
	public void method() {
		//System.err.println(sqlSession);
		System.err.println(itemDao.allItem());
	}
	
}
