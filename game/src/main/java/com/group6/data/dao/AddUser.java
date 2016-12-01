package com.group6.data.dao;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AddUser {

	// private String title;

	public static boolean AddUser(int UID, String UName, String UPwd, String Email) {
		String driverName = "com.mysql.jdbc.Driver";// åŠ è½½JDBCé©±åŠ¨
		String dbURL="jdbc:mysql://127.0.0.1:3306/GameCraft?verifyServerCertificate=false&useSSL=true";
		String userName = "root";// ç”¨æˆ·å�� ï¼ˆç¡®ä¿�è¯¥ç”¨æˆ·å’Œæ•°æ�®åº“æœ‰æ˜ å°„å…³ç³»ï¼Œå�³æœ‰æ�ƒé™�è®¿é—®ï¼‰
		String userPwd = "group6";// å¯†ç �
		Connection dbConn = null;
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);// è¿žæŽ¥æœ�åŠ¡å™¨å’Œæ•°æ�®åº“
			// System.out.println("Connection
			// Successful!");//å¦‚æžœè¿žæŽ¥æˆ�åŠŸï¼ŒæŽ§åˆ¶å�°è¾“å‡ºConnection Successful!
		} catch (Exception e) {
			e.printStackTrace();
		}
		// å»ºç«‹Statementå¯¹è±¡
		Statement st = null;// Statement æ��ä¾›æ‰§è¡ŒåŸºæœ¬SQLè¯­å�¥æ“�ä½œçš„åŠŸèƒ½
		try {
			st = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// æ‰§è¡ŒSQLè¯­å�¥
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.print("User Name "); String UNAME =
		 * scanner.next().toString();
		 */

		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// df.format(System.currentTimeMillis());
		String sql = "insert into AccountInfo (UID, UName, UPwd, Email) values('" + UID + "','" + UName + "','"+ UPwd + "','" + Email + "')";
		int rs = 0;
		try {
			rs = st.executeUpdate(sql);
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rs == 1)
			return true;

		return false;

	}

	
	 public static void main(String[] args) { AddUser(100003,"zjq","123","zjq@gmail.com");
	 

}
}