package com.group6.data.format.JUnit;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.group6.data.format.FormatTime;

public class FormatTimejavaJUnit {

	@Test
	public void test() {
		long Date= 1479435313073l;
		
		assertEquals("2016-11-17 10:15:13", FormatTime.changeToSimpleDate(Date));
		
	}

}
