package net.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	public MemberDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/PostgresDB");
			conn = ds.getConnection();
			System.out.println("DB 연결 성공");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	// 회원가입
	public boolean memberInsert(MemberBean member) {
		int num = 0;
		String sql = "";

		int result = 0;

		try {
			pstm = conn.prepareStatement("select max(member_num) from member");
			rs = pstm.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			sql = "insert into member (MEMBER_NUM, ID, PW, EMAIL, NAME, ";
			sql += "ADDR, PIN, YEAR, MONTH, DAY, HOBBY, INTRO"
					+ ") values(?,?,?,?,?,?,?,?,?,?,?,?)";

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
			pstm.setString(2, member.getID());
			pstm.setString(3, member.getPW());
			pstm.setString(4, member.getEMAIL());
			pstm.setString(5, member.getNAME());
			pstm.setString(6, member.getADDR());
			pstm.setString(7, member.getPIN());
			pstm.setString(8, member.getYEAR());
			pstm.setString(9, member.getMONTH());
			pstm.setString(10, member.getDAY());
			pstm.setString(11, member.getHOBBY());
			pstm.setString(12, member.getINTRO());

			result = pstm.executeUpdate();
			System.out.println(result);
			if (result == 0) {
				
				return false;
			}
			return true;
		} catch (Exception ex) {
			System.out.println("memberInsert 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException ex) {
				}
		}
		return false;
	}

	public boolean memberLogin(MemberBean member) {
		String sql = "SELECT id , pw FROM member WHERE id = '" + member.getID() + "'";
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(2).equals(member.getPW())) {
					return true;
				}
			}
			return false;
		} catch(Exception e) {
			System.out.println("DAO : member Login : " + e);
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch (SQLException ex) {}
			if(pstm!=null) try{pstm.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		return false;
	}
	
	public ArrayList<Object> memberList() {
		String sql = "SELECT * FROM MEMBER";
		ArrayList<Object> list = new ArrayList<>();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				MemberBean member = new MemberBean();
				member.setID(rs.getString("id"));
				member.setPW(rs.getString("pw"));
				member.setEMAIL(rs.getString("email"));
				member.setNAME(rs.getString("name"));
				member.setADDR(rs.getString("addr"));
				member.setPIN(rs.getString("pin"));
				member.setYEAR(rs.getString("year"));
				member.setMONTH(rs.getString("month"));
				member.setDAY(rs.getString("day"));
				member.setHOBBY(rs.getString("hobby"));
				member.setINTRO(rs.getString("intro"));
				list.add(member);
			}
			
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}catch(SQLException ex) {}
			if(pstm!=null) try {pstm.close();}catch(SQLException ex) {}
			if(conn!=null) try {conn.close();}catch(SQLException ex) {}
		}
		return null;
	}
	
	public MemberBean memberInfo(MemberBean m) {
		String sql = "SELECT * FROM MEMBER WHERE ID='"+m.getID()+"'";
		MemberBean member = new MemberBean();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()) {
				member.setID(rs.getString("id"));
				member.setPW(rs.getString("pw"));
				member.setEMAIL(rs.getString("email"));
				member.setNAME(rs.getString("name"));
				member.setADDR(rs.getString("addr"));
				member.setPIN(rs.getString("pin"));
				member.setYEAR(rs.getString("year"));
				member.setMONTH(rs.getString("month"));
				member.setDAY(rs.getString("day"));
				member.setHOBBY(rs.getString("hobby"));
				member.setINTRO(rs.getString("intro"));
				
				return member;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException ex) {}
			if(pstm!=null) try{pstm.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		return null;
	}
	
	public boolean memberDelete(String id) {
		String sql = "DELETE FROM MEMBER WHERE ID='"+id+"'";
		try {
			pstm = conn.prepareStatement(sql);
			int result = pstm.executeUpdate();
			
			if(result != 0) {
				return true;
			}
			
			return false;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException ex) {}
			if(pstm!=null) try{pstm.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		return false;
		
	}
	
	public boolean isMemberExist(String id) {
		String sql = "SELECT id FROM MEMBER WHERE id='"+id+"'";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		
			if(rs.next()) {
				
				return true;
			}
			return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
