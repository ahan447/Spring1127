package repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링의 Bean Factory 클래스라는 어노테이션
@Configuration
public class DAOFactory {
	//스프링에서 객체를 생성해준다는 어노테이션
	@Bean
	//DAO 객체를 생성해서 리턴해주는 메소드
	public static DAO create() {
		return new DAO();
	}

}
