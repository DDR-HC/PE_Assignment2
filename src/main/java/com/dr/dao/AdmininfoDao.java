package com.dr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dr.entity.Admininfo;
import com.dr.utils.GetConnection;

public class AdmininfoDao {
	//search admininfo
	public static int searchByAIDAndPsw(Admininfo ai) {
		int status=0;
		try {
			Connection connection=GetConnection.getConnection();
			PreparedStatement pst=connection.prepareStatement("select * from Admininfo where AID=? and psw=?");
			pst.setInt(1,ai.getAID());
			pst.setString(2,ai.getPsw());
			status=pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
}
