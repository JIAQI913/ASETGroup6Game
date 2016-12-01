package com.group6.data.format.JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.group6.data.format.FormatList;

public class FormatListjavaJUnit {
	/**
	 * Test the class of FormatList.java
	 */

	@Test
	public void test() {
		String str = new String("st");
		List<String> L1 = new ArrayList<String>();
		L1.add(str);
		assertEquals(  "st"  ,FormatList.changeToString(L1));
		
		String str1 = new String ("fs");
		String str2 = new String ("s");
		List<String> L2 = new ArrayList<String>();
		L2.add(str1);
		L2.add(str2);
		assertEquals( "fs,s" , FormatList.changeToString(L2));
}
}