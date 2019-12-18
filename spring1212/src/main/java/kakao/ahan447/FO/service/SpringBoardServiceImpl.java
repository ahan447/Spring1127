package kakao.ahan447.FO.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kakao.ahan447.FO.DAO.SpringBoardDAO;
import kakao.ahan447.FO.domain.SpringBoard;
import kakao.ahan447.FO.domain.SpringUser;

@Service
public class SpringBoardServiceImpl implements SpringBoardService {
	@Autowired
	private SpringBoardDAO springBoardDao;

	@Override
	public boolean write(HttpServletRequest request) {
		boolean result = false;
		
		//필요한 파라미터 읽기
		String boardtitle = request.getParameter("title");
		String boardconten = request.getParameter("content");
		//로그인 한 유저의 이메일 가져오기
		HttpSession session= request.getSession();
		SpringUser user =(SpringUser)session.getAttribute("user");
		String email = user.getEmail();
		//접속한 클라이언트 ip 가져오기
		String ip = request.getRemoteAddr();
		//글번호 만들기 - 가장 큰 글 번호 + 1
		int boardnum = 1;
		Integer num = springBoardDao.maxNum();
		if(num != null) {
			boardnum = num + 1;
		}
		
		//게시글 삽입을 위한 DTO 만들기
		SpringBoard board = new SpringBoard();
		board.setBoardnum(boardnum);
		board.setBoardtitle(boardtitle);
		board.setBoardcontent(boardconten);
		board.setEmail(email);
		board.setBoardip(ip);
		
		//Dao 메소드 호출
		int r = springBoardDao.write(board);
		//결과 생성
		if(r > 0){
			result = true;
		}
		
		
		return result;
	}

	@Override
	public List<SpringBoard> list(HttpServletRequest reqiest) {
		
		List<SpringBoard> list = springBoardDao.list();
		//오늘 날짤 생성
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String t = sdf.format(today);
		
		for(SpringBoard board : list) {
			/*
			//오늘의 날짜 만들기
			int tYear = today.getYear();
			int tMonth = today.getMonth();
			int tDay = today.getDay();
			
			int bYear = board.getUpdatedate().getYear();
			int bMonth = board.getUpdatedate().getMonth();
			int bDay = board.getUpdatedate().getDay();
			*/
			if(t.equals(sdf.format(board.getUpdatedate()))) {
				SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
						board.setDispdate(sdf1.format(board.getUpdatedate()));
			}else {
				board.setDispdate(sdf.format(board.getUpdatedate()));
			}
		}
		return list;
	}
}
