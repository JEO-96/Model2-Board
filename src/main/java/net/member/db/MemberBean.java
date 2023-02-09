package net.member.db;

import java.sql.Date;

public class MemberBean {
	private int MEMBER_NUM; // 고유번호
	private String ID; // 아이디
	private String PW; // 비밀번호
	private String EMAIL; // 이메일
	private String NAME; // 이름
	private String ADDR;	// 주소
	private String PIN;	// 주민번호
	private String YEAR;	// 탄생년도
	private String MONTH;	// 탄생월
	private String DAY;	// 생일
	private String HOBBY;	// 취미
	private String INTRO;	// 자기소개
	
	public int getMEMBER_NUM() {
		return MEMBER_NUM;
	}
	public void setMEMBER_NUM(int mEMBER_NUM) {
		MEMBER_NUM = mEMBER_NUM;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getADDR() {
		return ADDR;
	}
	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String pIN) {
		PIN = pIN;
	}
	public String getYEAR() {
		return YEAR;
	}
	public void setYEAR(String yEAR) {
		YEAR = yEAR;
	}
	public String getMONTH() {
		return MONTH;
	}
	public void setMONTH(String mONTH) {
		MONTH = mONTH;
	}
	public String getDAY() {
		return DAY;
	}
	public void setDAY(String dAY) {
		DAY = dAY;
	}
	public String getHOBBY() {
		return HOBBY;
	}
	public void setHOBBY(String hOBBY) {
		HOBBY = hOBBY;
	}
	public String getINTRO() {
		return INTRO;
	}
	public void setINTRO(String iNTRO) {
		INTRO = iNTRO;
	}
	
	
}