package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.member.action.ActionForward;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberJoinAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		MemberDAO memberdao=new MemberDAO();
	   	MemberBean memberdata=new MemberBean();
	   	ActionForward forward=new ActionForward();
	   	request.setCharacterEncoding("UTF-8");
	   	response.setCharacterEncoding("UTF-8");
   		
   		
   		boolean result=false;
   		
   		try{
   			memberdata.setID(request.getParameter("id"));
   			memberdata.setPW(request.getParameter("pw"));
   			memberdata.setEMAIL(request.getParameter("email"));
   			memberdata.setNAME(request.getParameter("name"));
   			memberdata.setADDR(request.getParameter("addr"));
   			memberdata.setPIN(request.getParameter("pin"));
   			memberdata.setYEAR(request.getParameter("year"));
   			memberdata.setMONTH(request.getParameter("month"));
	   		memberdata.setDAY(request.getParameter("day"));
	   		String hobby = "";
	   		String[] arr = request.getParameterValues("hobby");
	   		for (String string : arr) {
	   			hobby += string;
			}

	   		
	   		memberdata.setHOBBY(hobby);
	   		memberdata.setINTRO(request.getParameter("intro"));
	   		if(memberdao.isMemberExist(memberdata.getID())) {
	   			PrintWriter out = response.getWriter();
	   			out.print("<html><head><meta charset=\"UTF-8\">");
	   			out.print("<script>");
	   			out.print("alert('아이디가 존재합니다.');");
	   			out.print("location.href='./joinForm.me';");
	   			out.print("</script>");
	   			out.print("</head></html>");
	   			out.close();
	   			return null;
	   		} 
	   		System.out.println("유저 회원가입 직전");
   			result=memberdao.memberInsert(memberdata);
   			System.out.println("유저 회원가입 후");
	   		
	   		if(result==false){
	   			System.out.println("회원가입 실패");
	   			return null;
	   		}
	   		System.out.println("회원가입 완료");
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("./main.me");
	   		return forward;
	   		
	   		
	   		
	   		
	   		
  		}catch(Exception ex){
   			ex.printStackTrace();
   		}
  		return null;
	}
}
