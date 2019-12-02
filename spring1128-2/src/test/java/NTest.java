import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gmail.neo.damain.Member;

//이 코드는 복사하면 import가 안되는 경우가 있음
@RunWith(SpringJUnit4ClassRunner.class)
// 설정 파일의 내용을 실행하도록 하는 설정
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })

public class NTest {
	// 동일한 자료형의 bean이 있으면 자동으로 주입
/*	@Autowired
	private DataSource dataSource;

	@Test
	public void connctionTest() {
		try {
			Connection con = dataSource.getConnection();
			System.err.println(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
*/	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void myBatisTest() {
		Member member = new Member();
		member.setEmail("neo@kakao.com");
		member.setPassword("1234");
		member.setName("이은지");
		member.setNickname("새송");
		member.setImage("default.png");
	Calendar cal =
			new GregorianCalendar(1991,5,14,112,2);
	Date birthday = new Date(cal.getTimeInMillis());
	member.setBirthday(birthday);
	
	//insert 구문 실행 
	//나은 결과값도 확인하고 데이터베이스도 확인
	//데이터베이스에 삽입이 되는데 결과기 이상하면 Service나 
	System.out.println(sqlSession.insert("member insert" , member));
	
	
	}
	
}
