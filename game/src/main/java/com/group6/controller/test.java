package com.group6.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.group6.model.Game;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class test {
	public static <AnyType> String changeToString(List<AnyType> i) {
		String str = "";
		for (AnyType temp : i) {
			// System.out.println(temp);
			str += temp;
			str += ',';
		}
		return str.substring(0, str.length() - 1);
	}
	public static void main(String[] args) {
		List l1=new ArrayList();
		l1.add(1);
		List l2=new ArrayList();
		l2.add("dfsdfsdfsd");
		System.out.println(changeToString(l1));
		System.out.println(changeToString(l2));
//		try {
//			HttpResponse<String> response = Unirest
//					.get("https://igdbcom-internet-game-database-v1.p.mashape.com/games/9630?fields=name")
//					.header("X-Mashape-Key", "xxrvfrwHt6mshHaQgrsADlFVlgAZp1Q8y6sjsnql2D1H2MpWBz")
//					.header("Accept", "application/json").asString();
//			System.out.println(response.getBody());
//			JsonParser parser = new JsonParser();
//			JsonElement el = parser.parse(response.getBody());
//
//			Gson gson = new Gson();
//			Game game = new Game();
//			// JsonElement===>>>JavaBean
//			game = gson.fromJson(el, Game.class);
//			System.out.println(game.getName());
//			// JsonParser parser = new JsonParser();
//			//
//			// JsonElement el = parser.parse(response.getBody());
//			//
//			// JsonArray jsonArray = null;
//			// if (el.isJsonArray()) {
//			// jsonArray = el.getAsJsonArray();
//			// }
//			// // traversal the list
//			// List<Game> gameList = new ArrayList<Game>();
//			// Game game = new Game();
//			// Iterator it = jsonArray.iterator();
//			// Gson gson = new Gson();
//			// while (it.hasNext()) {
//			// JsonElement e = (JsonElement) it.next();
//			// // JsonElement===>>>JavaBean
//			// game = gson.fromJson(e, Game.class);
//			// gameList.add(game);
//			// }
//			// System.out.println(gameList.get(0).getName());
//		} catch (UnirestException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
}
