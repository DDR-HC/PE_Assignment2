package com.dr.service.impl;

import com.dr.dao.AdmininfoDao;
import com.dr.entity.Admininfo;

public class AdmininfoServiceImpl {
	//search by AID and password
	public static int searchByUsernameAndPsw(String username, String psw) {
		Admininfo ai=new Admininfo();
		ai.setUsername(username);
		ai.setPsw(psw);
		return AdmininfoDao.searchByUsernameAndPsw(ai).getUsername().equals(username) ? 1 : 0;
	}	
}
