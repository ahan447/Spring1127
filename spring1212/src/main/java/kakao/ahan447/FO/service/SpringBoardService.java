package kakao.ahan447.FO.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kakao.ahan447.FO.domain.SpringBoard;

public interface SpringBoardService {
	//게시글 작성을 처리하기 위한 메소드
	public boolean write(HttpServletRequest request);
	
	//목록보기를 위한 메소드
	public List<SpringBoard> list(HttpServletRequest reqiest);
}
