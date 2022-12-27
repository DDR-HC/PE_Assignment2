package com.dr.entity;

//Admininfo table
public class Admininfo {
	//admin ID
	private int AID;
	
	//username
	private String username;
	
	//password
	private String psw;
	
	public int getAID() {
		return AID;
	}
	public void setAID(int aID) {
		AID = aID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
	
}
