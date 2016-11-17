package com.group6.data.format;

import java.util.List;

public class FormatList {
	public static <AnyType> String changeToString(List<AnyType> i) {
		String str = "";
		for (AnyType temp : i) {
			// System.out.println(temp);
			str += temp;
			str += ',';
		}
		return str.substring(0, str.length() - 1);
	}
	public static String changeToString(int i) {
		return i+"";
	}
}
