package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.Item;

@Component
public class ItemDAO {
	//setter 를 생성해주고 외부에 동일한 자료형의 bean이 있으면 자동 주입
	@Autowired
	private String name;
	
	
	/*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	*/
	public void getOne() {
		Item item = new Item();
		item.setNum(1);
		item.setName(name);
		//item.setName("이");
		item.setManufacture("은지");
		item.setPrice(4000);
		
		System.out.println(item);
	}
}
