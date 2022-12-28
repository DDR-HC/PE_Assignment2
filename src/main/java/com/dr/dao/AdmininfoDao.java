package com.dr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dr.entity.Admininfo;
import com.dr.utils.GetConnection;

public class AdmininfoDao {
	//search admininfo
	public static int searchByUsernameAndPsw(Admininfo ai) {
		int status=0;
		try {
			Connection connection=GetConnection.getConnection();
			PreparedStatement pst=connection.prepareStatement("select * from Admininfo where username=? and psw=?");
			pst.setString(1,ai.getUsername());
			pst.setString(2,ai.getPsw());
			status=pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
}
