package jp.co.f1.jdbc.ch02;

import java.sql.*;

public class SampleSelect {
	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/mybookdb";
	private static String USER = "bms";
	private static String PASSWORD = "password";

	public static void main(String[] args) {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement smt = con.createStatement();
			String sql = "SELECT * FROM bookinfo";
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				System.out.println("isbn ->" + rs.getString("isbn") + " title ->" + rs.getString("title") + " price -> "
						+ rs.getString("price"));
			}

			smt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("JDBC db connection error.");
		}
	}

}
