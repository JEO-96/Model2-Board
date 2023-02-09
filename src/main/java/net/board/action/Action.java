package net.board.action;

import javax.servlet.http.*;

public interface Action {  // 동적바인딩.
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception;
}
