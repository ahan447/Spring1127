package kakao.neo.service;

import java.security.Provider.Service;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import gmail.neo.damain.Member;

public class MemberService {

	// Bean을 자동생성하기 위한 어노테이션
	@Service
	public class MemberService {
		@Autowired
		private MemberDai memberDai;

		// 데이터 삽입하는 메소드
		public boolean insert() {
			boolean result = false;

			return result;

		}
	}
		public void myBatisTest() {
			Member member = new Member();
			member.setEmail("neo@kakao.com");
			member.setPassword("1234");
			member.setName("이은지");
			member.setNickname("새송");
			member.setImage("default.png");
			Calendar cal = new GregorianCalendar(1991, 5, 14, 112, 2);
			Date birthday = new Date(cal.getTimeInMillis());
			member.setBirthday(birthday);
		
	}
		
	//전체 데이터를 가져오는 메소드
	public void allMember() {
		//웹이면 뷰에서 데이터를 출력하기 위해서 저장하는 작업을 함
		//여러 개를 리턴하는 메소드는 반복문을 사용할 수 있게 하기 위해서
		//데이터가 없으면 size=0의 형태로 리턴
		//NullPointerException을 만들지 않기 위해서
		List<Member> list = memberDao.allMember();
		for(Member member : list) {
			System.out.println(member);
		}
	}
		
		
		
		
		
		
}