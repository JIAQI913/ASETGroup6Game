package com.group6.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.group6.model.Game;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
public class SearchController {
	final static int limit = 10;
	static int offset = 0;

	@RequestMapping("/Search")
	public void SearchController(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Game> list = new ArrayList<Game>();
		String searchName = req.getParameter("gameName");
		try {
			HttpResponse<String> responseCount = Unirest
					.get("https://igdbcom-internet-game-database-v1.p.mashape.com//games/count?search=" + searchName)
					.header("X-Mashape-Key", "xxrvfrwHt6mshHaQgrsADlFVlgAZp1Q8y6sjsnql2D1H2MpWBz")
					.header("Accept", "application/json").asString();
			
			
			HttpResponse<String> response = Unirest
					.get("https://igdbcom-internet-game-database-v1.p.mashape.com/games/?fields=*&limit=" + limit
							+ "&offset=" + offset + "&order=release_dates.date%3Adesc&search=" + searchName)
					.header("X-Mashape-Key", "xxrvfrwHt6mshHaQgrsADlFVlgAZp1Q8y6sjsnql2D1H2MpWBz")
					.header("Accept", "application/json").asString();
			JsonParser parser = new JsonParser();

			// JsonParser can transfer a string with json format into
			// JsonElement
			JsonElement el = parser.parse(response.getBody());

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
//			System.out.println(responseCount.getBody());
//			System.out.println(response.getBody());
//			System.out.println("{\"gameCount\":"+responseCount.getBody()+",\"gameDetail\":"+response.getBody()+"}");

			// traversal the list
			List<Game> gameList = new ArrayList<Game>();
			Game game = new Game();
			Iterator it = jsonArray.iterator();
			Gson gson = new Gson();
			while (it.hasNext()) {
				JsonElement e = (JsonElement) it.next();
				// JsonElement===>>>JavaBean
				game = gson.fromJson(e, Game.class);
				gameList.add(game);
			}
			resp.getWriter().write("{\"gameCount\":"+responseCount.getBody()+",\"gameDetail\":"+response.getBody()+"}");
			// try {
			// resp.getWriter().write(response.getBody());
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @RequestMapping(value = "/SearchTodo")
	// @ResponseBody
	// public void SearchTodo(HttpServletRequest req, HttpServletResponse resp)
	// {
	// String searchName = req.getParameter("name");
	// try {
	// HttpResponse<String> response = Unirest
	// .get("https://igdbcom-internet-game-database-v1.p.mashape.com/games/?fields=*&limit="
	// + limit
	// + "&offset=" + offset + "&order=release_dates.date%3Adesc&search=" +
	// searchName)
	// .header("X-Mashape-Key",
	// "xxrvfrwHt6mshHaQgrsADlFVlgAZp1Q8y6sjsnql2D1H2MpWBz")
	// .header("Accept", "application/json").asString();
	// resp.getWriter().write(response.getBody());
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}
