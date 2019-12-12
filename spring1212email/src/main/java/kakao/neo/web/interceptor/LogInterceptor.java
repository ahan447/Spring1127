package kakao.neo.web.interceptor;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//객체가 자동 생성 되고 bean 아이디는 logInterceptor
@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

}
