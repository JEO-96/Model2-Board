package net.board.action;

public class ActionForward {  // 전송방식 , 경로 
	private boolean isRedirect=false;
	private String path=null;
	
	public boolean isRedirect(){
		return isRedirect;
	}
	
	public String getPath(){
		return path;
	}
	
	public void setRedirect(boolean b){
		isRedirect=b;
	}
	
	public void setPath(String string){
		path=string;
	}
}