package com.irctc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
	private static Connection cn = null;

	private DBCon() {
		try {
			Class.forName("org.postgresql.Driver");
			DBCon.cn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
					"plf_training_admin", "pff123");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (DBCon.cn == null) {
			new DBCon();
		}
		return DBCon.cn;

	}

}