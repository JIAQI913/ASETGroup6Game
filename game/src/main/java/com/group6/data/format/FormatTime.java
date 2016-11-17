package com.group6.data.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FormatTime {
	public static String changeToSimpleDate(long time) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(time);
	}
	
	public static void main(String[] args) {
		long time=1465812201970l;
		System.out.println(changeToSimpleDate(time));
	}
}
