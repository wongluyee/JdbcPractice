package jp.co.f1.jdbc.ch02;

import java.sql.*;

public class SampleUpdate {
	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/mybookdb";
	private static String USER = "bms";
	private static String PASSWORD = "password";

	public static void main(String[] args) {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement smt = con.createStatement();
			String sql = "UPDATE bookinfo SET isbn = '00004' WHERE title = 'Spring Framework'";
			int rowsCount = smt.executeUpdate(sql);
			System.out.println(rowsCount + " record(s) updated.");

			smt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("Fail to connect JDBC db." + e);
		}

	}

}
