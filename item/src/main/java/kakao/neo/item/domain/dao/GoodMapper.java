package kakao.neo.item.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kakao.neo.item.domain.Item;

@Repository
public interface GoodMapper {
	@Select("select * from item")
	public List<Item> allItem();

	//itemid를 가지고 하나의 데이터를 가져오는 메소드
	@Select("select * from item where itemid=#{itemid}")
	public Item getItem(int itemid);

}
