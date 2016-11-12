package com.group6.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class GetString {
	public static <AnyType> String changeToString(List<AnyType> i) {
		String str = "";
		for (AnyType temp : i) {
			// System.out.println(temp);
			str += " "+temp;
			str += ',';
		}
		return str.substring(0, str.length() - 1);
	}

	public static List<String> transferToString(String type, List<Integer> i) {
		try {
			List<String> list = new ArrayList<String>();
			HttpResponse<String> response = Unirest
					.get("https://igdbcom-internet-game-database-v1.p.mashape.com/" + type + "/" + changeToString(i)
							+ "?fields=name")
					.header("X-Mashape-Key", "xxrvfrwHt6mshHaQgrsADlFVlgAZp1Q8y6sjsnql2D1H2MpWBz")
					.header("Accept", "application/json").asString();
			JsonParser parser = new JsonParser();
			JsonElement el = parser.parse(response.getBody());

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
	
	public static List<String> transferToString(String type, int i) {
		List l=new ArrayList();
		l.add(i);
		return transferToString(type, l);
	}

	public String transferCategory(int i) {
		String str = "";
		switch (i) {
		case 0:
			str = "Main Game";
			break;
		case 1:
			str="DLC/Addon";
			break;
		case 2:
			str="Expansion";
			break;
		case 3:
			str="Bundle";
			break;
		case 4:
			str="Standalone Expansion";
			break;
		default:
			str="Not defined";
		}
		return str;
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
