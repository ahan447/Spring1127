package kakao.neo.spring.validator;



import kakao.neo.spring.domain.Member;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//Member 클래스에 대한 유효성 검사 클래스
public class MemberValidator implements Validator {
	
	//어떤 클래스를 유효성 검사할 것이닞 설정하는 메소드
	@Override
	public boolean supports(Class<?> clazz) {
		// clazz에 Member 클래스의 객체를 할당할 수 있도록 해주는  설정
		return Member.class.isAssignableFrom(clazz);
	}

	//유효성 검사
	@Override
	public void validate(Object target, Errors errors) {
		//target을 유효성 검사할 객체로 형변환
		Member member = (Member)target;
		
		//아이디는 null 일 수 없고 좌우 공백을 제외한 글자수가 0일 수 없다
		if(member.getId() == null || member.getId().trim().length() <= 0) {
			
			//에러 메시지 설정
			//required.id 라는 메시지를 사용
			errors.rejectValue("id", "required");
			return;
		}
		if(member.getPw().trim().length() < 7) {
			//에러 메시지 설정
			//short.pw 라는 메시지를 사용
			errors.rejectValue("pw", "short");
		}
		String pw = member.getPw();
		char [] specials = {'!','@','#','$','%','^','&','*','(',')','_','+','|'};
		int etc = 0;
		for(int i=0; i<pw.length(); i=i+1) {
			char ch = pw.charAt(i);
			for(char t : specials) {
				if(ch == t ) {
					etc = etc + 1;
					break;
				}
			}
		}
		
		if(etc == 0 ) {
			errors.rejectValue("pw", "special");
		}
		
		
		

	}

}
