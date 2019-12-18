package kakao.ahan447.FO.domain;

import java.util.Date;

import lombok.Data;

@Data
public class SpringBoard {
	//테이블에 존재하는 컬럼
	private int  boardnum;
	private String boardtitle;
	private String boardcontent;
	private int boardreadcnt;
	private Date boarddate;
	private String boardip;
	private Date updatedate;
	private String email;
	
	//테이블에는 없지만 출력할 떄 사용할 컬럼
	private String nickname;
	private String dispdate;
	
}
