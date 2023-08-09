package jp.co.f1.jdbc.ch02;

import java.sql.*;

public class SampleInsert {

	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/mybookdb";
	private static String USER = "bms";
	private static String PASSWORD = "password";

	public static void main(String[] args) {
		try {
			// load jdbc
			Class.forName(RDB_DRIVE);
			// connect db
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			// prepare statement
			Statement smt = con.createStatement();

			String sql = "INSERT INTO bookinfo(isbn, title, price) VALUES ('00006', 'Spring Framework', 2000)";
			int rowsCount = smt.executeUpdate(sql);

			System.out.println(rowsCount + " record(s) registered.");

			smt.close();
			con.close();

		} catch (Exception e) {
			System.out.println("Fail to connect JDBC db.");
		}

	}

}
