package jp.co.f1.jdbc.ch02;

import java.sql.*;

public class SampleDelete {
	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/mybookdb";
	private static String USER = "bms";
	private static String PASSWORD = "password";

	public static void main(String[] args) {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement smt = con.createStatement();
			String sql = "DELETE FROM bookinfo WHERE isbn = '00004'";

			int rowsCount = smt.executeUpdate(sql);

			System.out.println(rowsCount + " record(s) deleted.");

			smt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("エラー" + e);
		}

	}

}
