package com.group6.data.format;

import java.util.List;

/**
 * Class about some methods that can be used to handle with list.
 * 
 * @author Qihui Fan
 *
 */
public class FormatList {
	/**
	 * transfer list to String which can be used for searching or displaying.
	 * 
	 * @param i
	 *            the list.
	 * @return the transfered String.
	 */
	public static <AnyType> String changeToString(List<AnyType> i) {
		String str = "";
		for (AnyType temp : i) {
			// System.out.println(temp);
			str += temp;
			str += ',';
		}
		return str.substring(0, str.length() - 1);
	}
}
