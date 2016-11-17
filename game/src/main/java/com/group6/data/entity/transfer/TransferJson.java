package com.group6.data.entity.transfer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.group6.data.entity.Game;
import com.group6.web.interact.InteractWithIGDB;

public class TransferJson {
	public static String objectToJson(Object o) {
		Gson gson = new Gson();
		return gson.toJson(o);
	}

	public static <C> List<C> jsonToObject(String json, Class<C> c) {
		JsonParser parser = new JsonParser();

		// JsonParser can transfer a string with json format into
		// JsonElement
		JsonElement el = parser.parse(json);

		// JsonElement===>>>JsonObject
		// JsonObject jsonObj = null;
		// if(el.isJsonObject()){
		// jsonObj = el.getAsJsonObject();
		// }

		// JsonElement===>>>JsonArray
		JsonArray jsonArray = null;
		if (el.isJsonArray()) {
			jsonArray = el.getAsJsonArray();
		}
		// System.out.println(responseCount.getBody());
		// System.out.println(response.getBody());
		// System.out.println("{\"gameCount\":"+responseCount.getBody()+",\"gameDetail\":"+response.getBody()+"}");

		// traversal the list
		List<C> list = new ArrayList<C>();
		C temp;
		Iterator it = jsonArray.iterator();
		Gson gson = new Gson();
		while (it.hasNext()) {
			JsonElement e = (JsonElement) it.next();
			// JsonElement===>>>JavaBean
			temp = gson.fromJson(e, c);
			list.add(temp);
		}
		return list;
	}

//	public static void main(String[] args) {
//
//		String response = InteractWithIGDB.getGameList("fallout", 0, 5);
//		List<Game> list=new ArrayList<Game>();
//		list=jsonToObject(response, Game.class);
//		System.out.println(list.get(0).getName());
//	}

}
