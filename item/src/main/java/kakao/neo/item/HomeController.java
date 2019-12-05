package kakao.neo.item;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kakao.neo.item.domain.Item;
import kakao.neo.item.domain.dao.ItemDao;
import kakao.neo.item.service.ItemService;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ItemService itemService;
	
	//시작 요청을 처리하는 부분
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//서비스의 메소드를 호출
		List<Item> list = itemService.allItem();
		//데이터를 저장
		model.addAttribute("list", list);
		//출력할 뷰 이름을 리턴 - 포워딩
		return "home";
	}
	
	//detail/itemid 요청을 처리하는 메소드
	@RequestMapping(value="detail/{itemid}", method=RequestMethod.GET)
	//위의 {} 부분을 저장할 변수를 만들 때는 @PathVariable 뒤에 선언
	//{} 안의 이름과 변수명이 동일해야 함
	public String detail(@PathVariable int itemid, Model model) {
		//서비스 메소드 호출
		Item item = itemService.getItem(itemid);
		//데이터 저장
		model.addAttribute("item",item);
		
		return "detail";
	}
	
}
