package com.dr.service.impl;

import com.dr.dao.AdmininfoDao;
import com.dr.entity.Admininfo;

public class AdmininfoServiceImpl {
	//search by AID and password
	public int searchByAIDAndPsw(int AID, String psw) {
		Admininfo ai=new Admininfo();
		ai.setAID(AID);
		ai.setPsw(psw);
		return AdmininfoDao.searchByAIDAndPsw(ai);
	}
	
}
