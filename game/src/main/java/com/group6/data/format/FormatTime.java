package com.group6.data.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Class about some methods that transfer with different time formats.
 * 
 * @author Qihui Fan
 *
 */
public class FormatTime {
	/**
	 * Transfer mill time to simple date.
	 * 
	 * @param time
	 *            the mill time.
	 * @return the time with simple date.
	 */
	public static String changeToSimpleDate(long time) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(time);
	}
	//
	// public static void main(String[] args) {
	// long time=1465812201970l;
	// System.out.println(changeToSimpleDate(time));
	// }
}
