package com.group6.data.format;

public class FormatName {
	public static String changeName( String str){
		return str.replaceAll(" ", "+");
	}
	 public static void main(String[] args) {
		 String time="fallout 4";
		 System.out.println(changeName(time));
		 }
}
