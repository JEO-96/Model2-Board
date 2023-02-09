package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action { // 인터페이스는 동적바인딩 하기 위해서 사용 - 어디서든 똑같음
	// 인터페이스이므로 추상 메소드
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
