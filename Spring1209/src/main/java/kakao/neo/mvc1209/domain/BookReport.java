package kakao.neo.mvc1209.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
//가장 외각의 루트 태그
@XmlRootElement(name="Books")
public class BookReport {
	//객체 하나의 태그
	@XmlElement(name="Book")
	private List<Book> lsit;

	public List<Book> getLsit() {
		return lsit;
	}

	public void setLsit(List<Book> lsit) {
		this.lsit = lsit;
	}
	
}
