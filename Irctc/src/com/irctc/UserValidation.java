package com.irctc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserValidation {

	Connection cn = DBCon.getConnection();

	public int validate(String UName, String PWD) {
		PreparedStatement ps = null;
		try {
			ps = cn.prepareStatement("select pswd from i213_irctcusers where userid=?");
			ps.setString(1, UName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String pwd = rs.getString(1);
				if (PWD.equals(pwd)) {
					return 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
