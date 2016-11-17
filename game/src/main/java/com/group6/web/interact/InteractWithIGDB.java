package com.group6.web.interact;

import java.util.ArrayList;
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

public class InteractWithIGDB {
	final static String ID = "xxrvfrwHt6mshHaQgrsADlFVlgAZp1Q8y6sjsnql2D1H2MpWBz";

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

	public static List<String> getTypeString(String type, int i) {
		List l = new ArrayList();
		l.add(i);
		return getTypeString(type, l);
	}

	public static String getGameCount(String gameName) {
		try {
			HttpResponse<String> responseCount = Unirest
					.get("https://igdbcom-internet-game-database-v1.p.mashape.com//games/count?search=" + gameName)
					.header("X-Mashape-Key", ID).header("Accept", "application/json").asString();
			return responseCount.getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getGameList(String gameName, int offset, int limit) {
		try {
			HttpResponse<String> response = Unirest
					.get("https://igdbcom-internet-game-database-v1.p.mashape.com/games/?fields=*&limit=" + limit
							+ "&offset=" + offset + "&order=release_dates.date%3Adesc&search=" + gameName)
					.header("X-Mashape-Key", "xxrvfrwHt6mshHaQgrsADlFVlgAZp1Q8y6sjsnql2D1H2MpWBz")
					.header("Accept", "application/json").asString();
			return response.getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// public static void main(String[] args) {
	// List<Integer> list =new ArrayList<Integer>();
	// list.add(19534);
	// list.add(19533);
	// for(String s :transferToString("games", list)){
	// System.out.println(s);
	// }
	// }
}
