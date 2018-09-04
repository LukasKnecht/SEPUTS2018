package com.healthcareapplication;



public class UserLoginDbUtil {
	
//	private Connection con;
//	private PreparedStatement pst;
//	private ResultSet rs;
//
//	public UserLoginDbUtil() {
//		try {
//			String dbURL = "jdbc:mysql://localhost:3306/DCA";
//			String dbID = "root";
//			String dbPassword = "root";
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection(dbURL, dbID, dbPassword);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public int login(String userName, String userPassword) {
//		String SQL = "SELECT userPassword from login where userName = ?";
//		try {
//			pst = con.prepareStatement(SQL);
//			pst.setString(1, userName);
//			rs = pst.executeQuery();
//			if (rs.next()) {
//				if (rs.getString(1).equals(userPassword)) {
//					return 1; // successful login.
//				} else
//					return 0; // when the password is wrong.
//			}
//			return -1; // when there is no such id in database, returns -1;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -2; // when there is error in database.
//	}

}
