package com.group6.web.interact;

import java.util.ArrayList;
import com.group6.data.entity.ID;
import com.group6.data.entity.transfer.TransferAdvancedOptions;
import com.group6.data.entity.transfer.TransferJson;

import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.group6.data.entity.Game;
import com.group6.data.format.FormatList;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Class about interact with IGDB.com.
 * 
 * @author Qihui Fan
 *
 */
public class InteractWithIGDB {
	final static String ID = "xxrvfrwHt6mshHaQgrsADlFVlgAZp1Q8y6sjsnql2D1H2MpWBz";

	/**
	 * a method that gets information from IGDB.
	 * 
	 * @param type
	 *            the type of item that will be searched.
	 * @param i
	 *            the items that will be searched.
	 * @return the list of searching results .
	 */
	public static List<String> getTypeString(String type, List<Integer> i) {
		// System.out.println(FormatList.changeToString(i));
		try {
			List<String> list = new ArrayList<String>();
			HttpResponse<String> response = Unirest
					.get("https://igdbcom-internet-game-database-v1.p.mashape.com/" + type + "/"
							+ FormatList.changeToString(i) + "?fields=name")
					.header("X-Mashape-Key", ID).header("Accept", "application/json").asString();
			JsonParser parser = new JsonParser();
			JsonElement el = parser.parse(response.getBody());

			// System.out.println(response.getBody());

			JsonArray jsonArray = null;
			if (el.isJsonArray()) {
				jsonArray = el.getAsJsonArray();
			}
			// traversal the list
			List<Game> gameList = new ArrayList<Game>();
			Game game = new Game();
			Iterator it = jsonArray.iterator();
			Gson gson = new Gson();
			while (it.hasNext()) {
				JsonElement e = (JsonElement) it.next();
				// JsonElement===>>>JavaBean
				game = gson.fromJson(e, Game.class);
				list.add(game.getName());
			}
			return list;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * a method that gets information from IGDB.
	 * 
	 * @param type
	 *            the type of item that will be searched.
	 * @param i
	 *            the items that will be searched.
	 * @return the list of searching results .
	 */
	public static List<String> getTypeString(String type, int i) {
		List l = new ArrayList();
		l.add(i);
		return getTypeString(type, l);
	}

	/**
	 * a method that gets number of results from IGDB.
	 * 
	 * @param gameName
	 *            the game name that users searches.
	 * @return the number of results .
	 */
	public static String getGameCount(String gameName,String platforms, String years,
			String themes, String genres ) {
		String platform, year, theme, genre;
		platform=TransferAdvancedOptions.transferPlatform(platforms);
		genre=TransferAdvancedOptions.transferGenre(genres);
		theme=TransferAdvancedOptions.transferTheme(themes);
		year=TransferAdvancedOptions.transferYear(years);
		try {
			HttpResponse<String> responseCount = Unirest
					.get("https://igdbcom-internet-game-database-v1.p.mashape.com/games/count?search=" + gameName+platform+genre+theme+year)
					.header("X-Mashape-Key", ID).header("Accept", "application/json").asString();
			return responseCount.getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * a main method that gets games from IGDB.
	 * 
	 * @param gameName
	 *            the game name that users searches.
	 * @param offset
	 *            the page needed.
	 * @param limit
	 *            the number of results in one page.
	 * @return the result.
	 */
	public static String getGameList(String type, String name, int offset, int limit, String platforms, String years,
			String themes, String genres) {
		String platform, year, theme, genre;
//		if (!platforms.equals("*")) {
//			String p=InteractWithIGDB.getType("platforms", platforms);
//			platform = "&filter[platforms][eq]="+TransferJson.jsonToObject(p, ID.class).get(0).getId();
//		} else {
//			platform = "";
//		}
//		if (!genres.equals("*")) {
//			String g=InteractWithIGDB.getType("genres", genres);
//			genre = "&filter[genres][eq]="+TransferJson.jsonToObject(g, ID.class).get(0).getId();
//		} else {
//			genre = "";
//		}
//		if (!themes.equals("*")) {
//			String t=InteractWithIGDB.getType("themes", themes);
//			theme = "&filter[themes][eq]="+TransferJson.jsonToObject(t, ID.class).get(0).getId();
//		} else {
//			theme = "";
//		}
//		if (!years.equals("*")) {
//			year = "&filter[release_dates.date][gte]="+years + "-01-01";
//		} else {
//			year = "";
//		}
		platform=TransferAdvancedOptions.transferPlatform(platforms);
		genre=TransferAdvancedOptions.transferGenre(genres);
		theme=TransferAdvancedOptions.transferTheme(themes);
		year=TransferAdvancedOptions.transferYear(years);
		//System.out.println(platform);
		//System.out.println(genre);
		//System.out.println(theme);
		//System.out.println(year);

		try {
			HttpResponse<String> response = Unirest
					.get("https://igdbcom-internet-game-database-v1.p.mashape.com/" + type + "/?fields=*&limit=" + limit
							+ "&offset=" + offset + "&sort=1&search=" + name+platform+genre+theme+year)
					.header("X-Mashape-Key", "xxrvfrwHt6mshHaQgrsADlFVlgAZp1Q8y6sjsnql2D1H2MpWBz")
					.header("Accept", "application/json").asString();
			return response.getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getType(String type, String name) {
		try {
			HttpResponse<String> response = Unirest
					.get("https://igdbcom-internet-game-database-v1.p.mashape.com/" + type + "/?fields=id&search="
							+ name)
					.header("X-Mashape-Key", "xxrvfrwHt6mshHaQgrsADlFVlgAZp1Q8y6sjsnql2D1H2MpWBz")
					.header("Accept", "application/json").asString();
			return response.getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		// public static void main(String[] args) {
		// List<Integer> list =new ArrayList<Integer>();
		// list.add(19534);
		// list.add(19533);
		// for(String s :transferToString("games", list)){
		// System.out.println(s);
		// }
		// }
	}
}
