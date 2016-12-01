package com.group6.data.dao;

import java.sql.*;
import java.util.Scanner;
public class PI {


	public String getPassword(String name){
		String driverName="com.mysql.jdbc.Driver";//åŠ è½½JDBCé©±åŠ¨
	    String dbURL="jdbc:mysql://127.0.0.1:3306/GameCraft?verifyServerCertificate=false&useSSL=true";
	    //JDBCå��è®®
	    String userName = "root";//ç”¨æˆ·å�� ï¼ˆç¡®ä¿�è¯¥ç”¨æˆ·å’Œæ•°æ�®åº“æœ‰æ˜ å°„å…³ç³»ï¼Œå�³æœ‰æ�ƒé™�è®¿é—®ï¼‰
	    String userPwd = "group6";//å¯†ç �
	    Connection dbConn = null;
	    try {
	        Class.forName(driverName);
	        dbConn = DriverManager.getConnection(dbURL, userName, userPwd);//è¿žæŽ¥æœ�åŠ¡å™¨å’Œæ•°æ�®åº“
	        System.out.println("Connection Successful!");//å¦‚æžœè¿žæŽ¥æˆ�åŠŸï¼ŒæŽ§åˆ¶å�°è¾“å‡ºConnection Successful!     
	        }
	    catch (Exception e) {   
	            e.printStackTrace();
	            }  
	    //å»ºç«‹Statementå¯¹è±¡
	    Statement st=null;//Statement æ��ä¾›æ‰§è¡ŒåŸºæœ¬SQLè¯­å�¥æ“�ä½œçš„åŠŸèƒ½
	    try {
	        st = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	  //æ‰§è¡ŒSQLè¯­å�¥
	  /*
	    Scanner scanner = new Scanner(System.in);
	  System.out.print("User Name ");
	  String UNAME = scanner.next().toString();
	  */
	    String sql="select upwd from AccountInfo where uname = '" + name + "'";
	    String password = null  ;
	    ResultSet rs = null;   //ä¿�å­˜è¿”å›žçš„ç»“æžœé›†
	    try {
	        rs = st.executeQuery(sql);//ç”¨Statementå®žä¾‹çš„executeQueryï¼ˆï¼‰æ–¹æ³•æ‰§è¡ŒSQLè¯­å�¥
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    //èŽ·å¾—æŸ¥è¯¢ç»“æžœ
	    try {
	        while(rs.next()){
	        	password=rs.getString(1);
	            System.out.println("Passwordï¼š"+ password);
	            
	        }
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    //System.out.println("æ“�ä½œæˆ�åŠŸï¼�");
		try {
	        rs.close();
	        st.close();
	        dbConn.close();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	       
	    }
		 return password;
	    //å…³é—­åˆ›å»ºçš„å¯¹è±¡ï¼ˆå�Žæ‰“å¼€å…ˆå…³é—­ï¼‰
	    
	}
   public static void main(String[] args) {
    // TODO Auto-generated method stub
    //å�–å¾—æ•°æ�®åº“çš„è¿žæŽ¥
	   Scanner scanner = new Scanner(System.in);
	   String uname=scanner.next().toString();
    PI t=new PI();
    t.getPassword(uname);
    //System.out.println(t.getPassword(UNAME));
    }
}