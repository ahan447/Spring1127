package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import dao.ItemDao;

public class Main {

	public static void main(String[] args) {
		// 스프링 설정 파일 호출
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// 빈 가져오기
		ItemDao dao = context.getBean(ItemDao.class);
		// 전체 데이터 가져오기
		System.err.println(dao.list());
		//System.err.println(dao.get(0));
	}
}
