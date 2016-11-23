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
import com.group6.data.entity.ID;
import com.group6.data.entity.transfer.TransferJson;
import com.group6.data.format.FormatName;
import com.group6.web.interact.InteractWithIGDB;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
/**
 * the controller that search game.
 * 
 * @author Qihui Fan
 *
 */
@Controller
public class SearchController {
	/**
	 * search game by name.
	 */
	@RequestMapping("/Search")
	public void SearchNameController(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Game> list = new ArrayList<Game>();
		String type=req.getParameter("type");
		String name = FormatName.changeName(req.getParameter("name"));
		int limit = Integer.parseInt(req.getParameter("limit"));
		int offset = Integer.parseInt(req.getParameter("currentPage"))-1;
		String response=InteractWithIGDB.getGameList(type ,name, offset, limit,"*","*","*","*");
		String responseCount=InteractWithIGDB.getGameCount(name,"*","*","*","*");
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

	@RequestMapping("/AdvancedSearch")
	public void AdvancedSearchNameController(HttpServletRequest req, HttpServletResponse resp) {
		String platforms = FormatName.changeName(req.getParameter("platforms"));
		String genres = FormatName.changeName(req.getParameter("genres"));
		String themes = FormatName.changeName(req.getParameter("themes"));
		String years = FormatName.changeName(req.getParameter("years"));
//		System.out.println(platforms);System.out.println(genres);System.out.println(themes);System.out.println(years);
//		String p=InteractWithIGDB.getType("platforms", platforms);
//		String g=InteractWithIGDB.getType("genres", genres);
//		String t=InteractWithIGDB.getType("themes", themes);
//		System.out.println(p);System.out.println(g);System.out.println(t);
		
//		String platform=TransferJson.jsonToObject(p, ID.class).get(0).getId();
//		String genre=TransferJson.jsonToObject(g, ID.class).get(0).getId();
//		String theme=TransferJson.jsonToObject(t, ID.class).get(0).getId();
//		String year=years+"-01-01";
//		System.out.println(platform);System.out.println(genre);System.out.println(theme);System.out.println(year);
		
		ArrayList<Game> list = new ArrayList<Game>();
		String type=req.getParameter("type");
		String name = FormatName.changeName(req.getParameter("name"));
		int limit = Integer.parseInt(req.getParameter("limit"));
		int offset = Integer.parseInt(req.getParameter("currentPage"))-1;
		String response=InteractWithIGDB.getGameList(type ,name, offset, limit,platforms,years,themes,genres);
		String responseCount=InteractWithIGDB.getGameCount(name,platforms,years,themes,genres);
		try {
			resp.getWriter().write("{\"gameCount\":"+responseCount+",\"gameDetail\":"+response+"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
