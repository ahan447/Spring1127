import org.junit.Test;

import gmail.neo.damain.Member;

public class UnitTesting {
	@Test
	public void testion() {
		Member member = new Member();
		member.setEmail("neo@kakao.com");
		System.err.println(member);
		
	}
}
