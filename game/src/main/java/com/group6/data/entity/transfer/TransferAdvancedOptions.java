package com.group6.data.entity.transfer;

import com.group6.data.entity.ID;
import com.group6.web.interact.InteractWithIGDB;

public class TransferAdvancedOptions {
	public static String transferPlatform( String platforms){
		String platform;
		if (!platforms.equals("*")) {
			System.out.println(platforms);
			String p=InteractWithIGDB.getType("platforms", platforms);
			System.out.println(p);
			platform = "&filter[release_dates.platform][eq]="+TransferJson.jsonToObject(p, ID.class).get(0).getId();
		} else {
			platform = "";
		}
		return platform;
	}
	public static String transferGenre(String genres){
		String genre;
		if (!genres.equals("*")) {
			String g=InteractWithIGDB.getType("genres", genres);
			genre = "&filter[genres][eq]="+TransferJson.jsonToObject(g, ID.class).get(0).getId();
		} else {
			genre = "";
		}
		return genre;
	}
	public static String transferTheme(String themes){
		String theme;
		if (!themes.equals("*")) {
			String t=InteractWithIGDB.getType("themes", themes);
			theme = "&filter[themes][eq]="+TransferJson.jsonToObject(t, ID.class).get(0).getId();
		} else {
			theme = "";
		}
		return theme;
	}
	public static String transferYear(String years){
		String year;
		if (!years.equals("*")) {
			year = "&filter[release_dates.date][gte]="+years + "-01-01";
		} else {
			year = "";
		}
		return year;
	}
}
