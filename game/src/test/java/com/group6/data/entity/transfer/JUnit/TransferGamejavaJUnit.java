package com.group6.data.entity.transfer.JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.group6.data.entity.Cover;
import com.group6.data.entity.CoverT;
import com.group6.data.entity.Game;
import com.group6.data.entity.GameT;
import com.group6.data.entity.Release_date;
import com.group6.data.entity.Release_dateT;
import com.group6.data.entity.Screenshot;
import com.group6.data.entity.ScreenshotT;
import com.group6.data.entity.Video;
import com.group6.data.entity.VideoT;
import com.group6.data.entity.transfer.TransferGame;

public class TransferGamejavaJUnit {

	@Test
	public void test() {
		String str1 = "Main Game";
		assertEquals("Main Game", TransferGame.transferCategory(0));
		String str2 = "DLC/Addon";
		assertEquals("DLC/Addon", TransferGame.transferCategory(1));
		String str3 = "Europe";
		assertEquals("Europe", TransferGame.transferRegion(1));
		
		Release_date date = new Release_date();
		date.setCategory(0);
		assertEquals("Main Game", TransferGame.transferRelease_date(date).getCategory());
		date.setRegion(1);
		assertEquals("Europe", TransferGame.transferRelease_date(date).getRegion());
		date.setPlatform(1);
		assertEquals("null", TransferGame.transferRelease_date(date).getPlatform());
		date.setDate(1479435313073l);
		assertEquals("2016-11-17 10:15:13", TransferGame.transferRelease_date(date).getDate());
		
//		List<Release_date> date1 = new ArrayList<Release_date>();
		Release_date date11 = new Release_date();
		date11.setCategory(0);
		assertEquals("Main Game", TransferGame.transferRelease_date(date11).getCategory());
		date11.setDate(1479435313073l);
		assertEquals("2016-11-17 10:15:13", TransferGame.transferRelease_date(date11).getDate());
		date11.setPlatform(1);
		assertEquals("null", TransferGame.transferRelease_date(date11).getPlatform());
		date11.setRegion(1);
		assertEquals("Europe", TransferGame.transferRelease_date(date11).getRegion());
		
		
		String size1 = "screenshot_med";
		Screenshot shot1 = new Screenshot("sdf", 100, 100);
		shot1.setCloudinary_id("sdf");
		assertEquals("https://res.cloudinary.com/igdb/image/upload/t_cover_big/sdf.jpg", TransferGame.transferScreenshot(shot1, "cover_big").getCloudinary_id());
        shot1.setHeight(2);
        assertEquals(2, TransferGame.transferScreenshot(shot1, "screenshot_med").getHeight());
        shot1.setWidth(3);
		assertEquals(3, TransferGame.transferScreenshot(shot1, "screenshot_med").getWidth());
		
		Video video1 = new Video("ds", "123");
		video1.setName("ds");
		assertEquals("ds", TransferGame.transferVideo(video1).getName() );
		video1.setVideo_id("123");
		assertEquals("https://youtu.be/123", TransferGame.transferVideo(video1).getVideo_id());
		
		String size2 = "cover_big";
		Cover cover1 = new Cover ("123", 100, 100);
		cover1.setCloudinary_id("123");
		assertEquals("https://res.cloudinary.com/igdb/image/upload/t_cover_big/123.jpg", TransferGame.transferCover(cover1, size2).getCloudinary_id());
		cover1.setHeight(3);
		assertEquals(3, TransferGame.transferCover(cover1, size2).getHeight());
		cover1.setWidth(3);
		assertEquals(3, TransferGame.transferCover(cover1, size2).getWidth());
		
	

		
		String size="screenshot_med";
		Screenshot shot=new Screenshot("asd", 100,100);
		assertEquals("https://res.cloudinary.com/igdb/image/upload/t_screenshot_med/asd.jpg", TransferGame.transferScreenshot(shot, size).getCloudinary_id());
	
		
		
		
	
	
	}

}
