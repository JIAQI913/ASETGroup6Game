package com.group6.data.dao;

import java.sql.*;
import java.util.Scanner;

public class GetIGNC {

	// private String title;

	public String getIGNComment(String title) {
		String driverName = "com.mysql.jdbc.Driver";// åŠ è½½JDBCé©±åŠ¨
		String dbURL="jdbc:mysql://127.0.0.1:3306/GameCraft?verifyServerCertificate=false&useSSL=true";
		String userName = "root";// ç”¨æˆ·å�� ï¼ˆç¡®ä¿�è¯¥ç”¨æˆ·å’Œæ•°æ�®åº“æœ‰æ˜ å°„å…³ç³»ï¼Œå�³æœ‰æ�ƒé™�è®¿é—®ï¼‰
		String userPwd = "group6";// å¯†ç �
		Connection dbConn = null;
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);// è¿žæŽ¥æœ�åŠ¡å™¨å’Œæ•°æ�®åº“
			// System.out.println("Connection
			// Successful!");// å¦‚æžœè¿žæŽ¥æˆ�åŠŸï¼ŒæŽ§åˆ¶å�°è¾“å‡ºConnection Successful!
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
		String sql1 = "select score_phrase, score from ign where title= '" + title  + "'";
//		String sql2 = "select comment from CommentInfo where title= '" + platform + "'";
		String score_phrase = null;
		String score = null;
		ResultSet rs = null;// ä¿�å­˜è¿”å›žçš„ç»“æžœé›†

		try {
			rs = st.executeQuery(sql1);// ç”¨Statementå®žä¾‹çš„executeQueryï¼ˆï¼‰æ–¹æ³•æ‰§è¡ŒSQLè¯­å�¥
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// èŽ·å¾—æŸ¥è¯¢ç»“æžœ
		try {
			while (rs.next()) {
				score_phrase = rs.getString(1);
				score = rs.getString(2);
				System.out.println("Score_phrase: " + score_phrase);
				System.out.println("Score: "+ score);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try{
//			while(rs.next()){
//			 score = rs.getString(2);
//				System.out.println("Score: "+ score);
//			}
//		} catch(SQLException e){
//			e.printStackTrace();
//		}
		// System.out.println("æ“�ä½œæˆ�åŠŸï¼�");
		try {
			rs.close();
			st.close();
			dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return title;
		
		
		// å…³é—­åˆ›å»ºçš„å¯¹è±¡ï¼ˆå�Žæ‰“å¼€å…ˆå…³é—­ï¼‰

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// å�–å¾—æ•°æ�®åº“çš„è¿žæŽ¥
		Scanner scanner = new Scanner(System.in);
		String title = scanner.next().toString();
//		String platform = scanner.next().toString();
		GetIGNC t = new GetIGNC();
		t.getIGNComment(title);
		 System.out.println(t.getIGNComment(title));
	}
}
