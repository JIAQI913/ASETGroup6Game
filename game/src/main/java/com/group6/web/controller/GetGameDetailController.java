package com.group6.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.group6.data.entity.Game;
import com.group6.data.entity.GameT;
import com.group6.data.entity.transfer.TransferGame;
import com.group6.data.entity.transfer.TransferJson;
import com.group6.data.format.FormatList;
import com.group6.web.interact.InteractWithIGDB;
import com.mashape.unirest.http.HttpResponse;

/**
 * the controller about game's details.
 * 
 * @author Qihui Fan
 *
 */
@Controller
public class GetGameDetailController {
	/**
	 * get game details and put it in session. Then go to gameDetail.jsp.
	 */
	@ResponseBody
	@RequestMapping("/getGameDetail")
	public String getGameDetail(@RequestBody Game game, HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.setAttribute("game", game);
		return "Success";
	}
	//
	// @RequestMapping("/showGameDetail")
	// public ModelAndView goToGameDetail() {
	// ModelAndView modelAndView = new ModelAndView();
	// // modelAndView.addObject("game",game);
	// modelAndView.setViewName("gameDetail");
	// return modelAndView;
	// }
	// public ModelAndView getGameDetail(@RequestParam("json") String
	// selectGameDetail, HttpServletRequest req,
	// HttpServletResponse resp) {
	// // System.out.println(selectGameDetail);
	// HttpSession session = req.getSession();
	// JsonParser parser = new JsonParser();
	// JsonElement el = parser.parse(selectGameDetail);
	// Game game = new Game();
	// Gson gson = new Gson();
	// game = gson.fromJson(el, Game.class);
	// session.setAttribute("game", game);
	// ModelAndView modelAndView = new ModelAndView();
	//// modelAndView.addObject("game",game);
	// modelAndView.setViewName("gameDetail");
	// return modelAndView;
	// }
	// @RequestMapping("/getGameDetail")
	// public ModelAndView getGameDetail(@RequestParam("json") String
	// selectGameDetail, HttpServletRequest req, HttpServletResponse resp) {
	// System.out.println(selectGameDetail);
	// HttpSession session=req.getSession();
	// JsonParser parser = new JsonParser();
	// JsonElement el = parser.parse(selectGameDetail);
	// Game game = new Game();
	// Gson gson = new Gson();
	// game = gson.fromJson(el, Game.class);
	// System.out.println(game.getName());
	// // String flag = "ok";
	// // PrintWriter out;
	// // try {
	// // out = resp.getWriter();
	// // Gson gson = new Gson();
	// // String flagJson = gson.toJson(flag);
	// // out.write(flagJson);
	// // } catch (IOException e) {
	// // // TODO Auto-generated catch block
	// // e.printStackTrace();
	// // }
	// ModelAndView modelAndView = new ModelAndView();
	// modelAndView.addObject("gameName", game.getName());
	// modelAndView.addObject("gameUrl", game.getUrl());
	// modelAndView.addObject("gameSummary", game.getSummary());
	// System.out.println(game.getDevelopers());
	// modelAndView.addObject("developers",
	// FormatList.changeToString(InteractWithIGDB.getTypeString("companies",
	// game.getDevelopers())));
	// modelAndView.addObject("publishers",
	// FormatList.changeToString(InteractWithIGDB.getTypeString("companies",
	// game.getPublishers())));
	// modelAndView.addObject("gameRelated",
	// FormatList.changeToString(InteractWithIGDB.getTypeString("games",
	// game.getGame())));
	// modelAndView.addObject("count",
	// session.getAttribute("responseCount"));
	// modelAndView.setViewName("gameDetail");
	// return modelAndView;
	// }
	// System.out.println(game.getName());
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

	// session.setAttribute("gameName", game.getName());
	// session.setAttribute("gameUrl", game.getUrl());
	// session.setAttribute("gameSummary", game.getSummary());
	// System.out.println(game.getDevelopers());
	// session.setAttribute("developers",
	// FormatList.changeToString(InteractWithIGDB.getTypeString("companies",
	// game.getDevelopers())));
	// session.setAttribute("publishers",
	// FormatList.changeToString(InteractWithIGDB.getTypeString("companies",
	// game.getPublishers())));
	// session.setAttribute("gameRelated",
	// FormatList.changeToString(InteractWithIGDB.getTypeString("games",
	// game.getGame())));

	// @ResponseBody
	// public ModelAndView testConverter(@RequestBody Game game)
	// {
	// System.out.println(game.getName());
	// ModelAndView modelAndView = new ModelAndView();
	// // modelAndView.addObject("game",game);
	// modelAndView.setViewName("gameDetail");
	//
	// return modelAndView;
	// }

	/**
	 * show game details when gameDetail.jsp is loading.
	 */
	@RequestMapping("/showGameDetail")
	@ResponseBody
	public GameT showGameDetail(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		GameT gameA = new GameT();
		TransferGame.transferGameAPI((Game) session.getAttribute("game"), gameA);
//		System.out.println(TransferJson.objectToJson(session.getAttribute("gameT")));
//		try {
//			resp.getWriter().write(TransferJson.objectToJson(gameT));
//			System.out.println(TransferJson.objectToJson(gameT));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return gameA;
	}

	@RequestMapping("/GoToGameDetail")
	public ModelAndView goToGameDetail(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = req.getSession();
		GameT gameT = new GameT();
		//System.out.println("**********************************");
		//System.out.println(session.getAttribute("game"));
		TransferGame.transferGameStatic((Game) session.getAttribute("game"), gameT);
		modelAndView.addObject("gameS",gameT);
		modelAndView.setViewName("gameDetail");
		return modelAndView;
	}
}
