package jp.co.f1.jdbc.ch02;

import java.sql.*;

public class SampleSelect2 {
	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/mybookdb";
	private static String USER = "bms";
	private static String PASSWORD = "password";

	public static void main(String[] args) {

		Connection con = null;
		Statement smt = null;

		try {
			Class.forName(RDB_DRIVE);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			smt = con.createStatement();
			String sql = "SELECT * FROM bookinfo";
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				System.out.println("isbn ->" + rs.getString("isbn") + " title ->" + rs.getString("title") + " price -> "
						+ rs.getString("price"));
			}

//			smt.close();
//			con.close();

		} catch (Exception e) {
			System.out.println("JDBC db connection error." + e);
		} finally {
			try {
				if (smt != null) {
					System.out.println("Close Statement.");
					smt.close();
				}

				if (con != null) {
					System.out.println("Disconnect db.");
					con.close();
				}

			} catch (SQLException ignore) {
				// 例外処理の無視
			}
		}
	}

}
