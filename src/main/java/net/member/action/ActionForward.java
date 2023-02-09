package net.member.action;

public class ActionForward { // 전송방식, 경로
	// 전송방식 결정 - 리다이렉트, 포워드 true이면 리다이렉트, false이면 리다이렉트
	private boolean isRedirect = false;
	private String path = null;
	
	public boolean isRedirect() {
		return isRedirect;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	

}
