package com.group6.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.group6.model.Game;
import com.group6.model.GetString;
import com.mashape.unirest.http.HttpResponse;

@Controller
public class GetGameDetailController {
	@RequestMapping("/getGameDetail")
	public ModelAndView SearchController(@RequestParam("selectGameDetail") String selectGameDetail) {
		System.out.println(selectGameDetail);
		JsonParser parser = new JsonParser();
		JsonElement el = parser.parse(selectGameDetail);
		Game game = new Game();
		Gson gson = new Gson();
		game = gson.fromJson(el, Game.class);
		System.out.println(game.getName());
		// String flag = "ok";
		// PrintWriter out;
		// try {
		// out = resp.getWriter();
		// Gson gson = new Gson();
		// String flagJson = gson.toJson(flag);
		// out.write(flagJson);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("gameName", game.getName());
		modelAndView.addObject("gameUrl", game.getUrl());
		modelAndView.addObject("gameSummary", game.getSummary());
		modelAndView.addObject("developers", GetString.changeToString(GetString.transferToString("companies", game.getDevelopers())));
		modelAndView.addObject("publishers", GetString.changeToString(GetString.transferToString("companies", game.getPublishers())));
		modelAndView.addObject("gameRelated", GetString.changeToString(GetString.transferToString("games", game.getGame())));
		
		modelAndView.setViewName("gameDetail");
		return modelAndView;
	}
}
