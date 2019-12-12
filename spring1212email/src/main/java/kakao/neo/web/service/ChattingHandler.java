package kakao.neo.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChattingHandler extends TextWebSocketHandler {
	//클라이언트들의 웹 소켓 세션에 저장할 List을 생성
	private List<WebSocketSession> list =
			new ArrayList<WebSocketSession>();
	

	@Override
	//클라이언트가 접속했을 때 호출되는 메소드
	public void afterConnectionEstablished(
			WebSocketSession WebSocketSession) {
		//접속한 클라이언트를 List에 저장
		list.add(WebSocketSession);
	}

	
	@Override
	//클라이언트가 접속해제되었을 때 호출되는 메소드
	public void afterConnectionClosed(
			WebSocketSession WebSocketSession, CloseStatus status) {
		//List에서 제거
		list.remove(WebSocketSession);
		
	}
	
	
	@Override
	//클라이언트로부터 메시지가 왔을 때 호출되는 메소드
	public void handleTextMessage(
			WebSocketSession WebSocketSession, TextMessage message) {
		//전송된 메시지 가져오기
		String msg = message.getPayload();
		//List의 모든 세션에게 메시지를 전송
		try {
			for(WebSocketSession ses : list) {
			ses.sendMessage(new TextMessage(msg));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		}

}
