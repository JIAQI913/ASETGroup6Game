package com.group6.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
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
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.group6.data.entity.Game;
import com.group6.web.interact.InteractWithIGDB;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
public class SearchController {

	@RequestMapping("/Search")
	public void SearchController(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Game> list = new ArrayList<Game>();
		String searchName = req.getParameter("gameName");
		int limit = Integer.parseInt(req.getParameter("limit"));
		int offset = Integer.parseInt(req.getParameter("currentPage"))-1;
		String response=InteractWithIGDB.getGameList(searchName, offset, limit);
		String responseCount=InteractWithIGDB.getGameCount(searchName);
		try {
			resp.getWriter().write("{\"gameCount\":"+responseCount+",\"gameDetail\":"+response+"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		HttpSession session=req.getSession();
//		session.setAttribute("responseCount", responseCount);
//			JsonParser parser = new JsonParser();
//
//			// JsonParser can transfer a string with json format into
//			// JsonElement
//			JsonElement el = parser.parse(response);
//
//			// JsonElement===>>>JsonObject
//			// JsonObject jsonObj = null;
//			// if(el.isJsonObject()){
//			// jsonObj = el.getAsJsonObject();
//			// }
//
//			// JsonElement===>>>JsonArray
//			JsonArray jsonArray = null;
//			if (el.isJsonArray()) {
//				jsonArray = el.getAsJsonArray();
//			}
////			System.out.println(responseCount.getBody());
////			System.out.println(response.getBody());
////			System.out.println("{\"gameCount\":"+responseCount.getBody()+",\"gameDetail\":"+response.getBody()+"}");
//
//			// traversal the list
//			List<Game> gameList = new ArrayList<Game>();
//			Game game = new Game();
//			Iterator it = jsonArray.iterator();
//			Gson gson = new Gson();
//			while (it.hasNext()) {
//				JsonElement e = (JsonElement) it.next();
//				// JsonElement===>>>JavaBean
//				game = gson.fromJson(e, Game.class);
//				gameList.add(game);
//			}
			// try {
			// resp.getWriter().write(response.getBody());
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
	}

//	 @RequestMapping(value = "/SearchTodo")
//	 @ResponseBody
//	 public String SearchTodo(@RequestBody ModelAndView model)
//	 {
//	 String searchName = model.get;
//	 String response=InteractWithIGDB.getGameList(searchName, 0, 10);
//	 return response;
//	 }
}
