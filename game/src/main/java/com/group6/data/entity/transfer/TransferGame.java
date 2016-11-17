package com.group6.data.entity.transfer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.group6.data.entity.Cover;
import com.group6.data.entity.CoverT;
import com.group6.data.entity.Game;
import com.group6.data.entity.GameT;
import com.group6.data.entity.Release_date;
import com.group6.data.entity.Release_dateT;
import com.group6.data.entity.Screenshot;
import com.group6.data.entity.ScreenshotT;
import com.group6.data.entity.Video;
import com.group6.data.entity.VideoT;
import com.group6.data.format.FormatList;
import com.group6.data.format.FormatTime;
import com.group6.web.interact.InteractWithIGDB;

public class TransferGame {
	public static String transferCategory(int i) {
		String str = "";
		switch (i) {
		case 0:
			str = "Main Game";
			break;
		case 1:
			str = "DLC/Addon";
			break;
		case 2:
			str = "Expansion";
			break;
		case 3:
			str = "Bundle";
			break;
		case 4:
			str = "Standalone Expansion";
			break;
		default:
			str = "Not defined";
		}
		return str;
	}

	public static String transferRegion(int i) {
		String str = "";
		switch (i) {
		case 1:
			str = "Europe";
			break;
		case 2:
			str = "North America";
			break;
		case 3:
			str = "Australia ";
			break;
		case 4:
			str = "New Zealand";
			break;
		case 5:
			str = "Japan";
			break;
		case 6:
			str = "China";
			break;
		case 7:
			str = "Asia";
			break;
		case 8:
			str = "Worldwide";
			break;
		default:
			str = "Not defined";
		}
		return str;
	}

	public static Release_dateT transferRelease_date(Release_date date) {
		Release_dateT dateT = new Release_dateT();
		dateT.setCategory(transferCategory(date.getCategory()));
		dateT.setPlatform(FormatList.changeToString(InteractWithIGDB.getTypeString("platforms", date.getPlatform())));
		dateT.setDate(FormatTime.changeToSimpleDate(date.getDate()));
		dateT.setRegion(transferRegion(date.getRegion()));
		return dateT;
	}

	public static List<Release_dateT> transferRelease_date(List<Release_date> date) {
		List<Release_dateT> dateT = new ArrayList<Release_dateT>();
		for (Release_date temp : date) {
			dateT.add(transferRelease_date(temp));
		}
		return dateT;
	}

	public static ScreenshotT transferScreenshot(Screenshot shot, String size) {
		ScreenshotT shotT = new ScreenshotT();
		shotT.setCloudinary_id(
				"https://res.cloudinary.com/igdb/image/upload/t_" + size + "/" + shot.getCloudinary_id() + ".jpg");
		shotT.setHeight(shot.getHeight());
		shotT.setWidth(shot.getWidth());
		return shotT;
	}

	public static List<ScreenshotT> transferScreenshot(List<Screenshot> shot, String size) {
		List<ScreenshotT> shotT = new ArrayList<ScreenshotT>();
		for (Screenshot temp : shot) {
			shotT.add(transferScreenshot(temp, size));
		}
		return shotT;
	}

	public static VideoT transferVideo(Video video) {
		VideoT videoT = new VideoT();
		videoT.setName(video.getName());
		videoT.setVideo_id("https://youtu.be/" + video.getVideo_id());
		return videoT;
	}

	public static List<VideoT> transferVideo(List<Video> video) {
		List<VideoT> videoT = new ArrayList<VideoT>();
		for (Video temp : video) {
			videoT.add(transferVideo(temp));
		}
		return videoT;
	}

	public static CoverT transferCover(Cover cover, String size) {
		CoverT coverT = new CoverT();
		coverT.setCloudinary_id(
				"https://res.cloudinary.com/igdb/image/upload/t_" + size + "/" + cover.getCloudinary_id() + ".jpg");
		coverT.setHeight(cover.getHeight());
		coverT.setWidth(cover.getWidth());
		return coverT;
	}

	public static void transferGame(Game game, GameT gameT) {
		gameT.setId(game.getId());
		gameT.setName(game.getName());
//		System.out.println(game.getAlternative_names());
		if (game.getAlternative_names()!=null)
			gameT.setAlternative_names(game.getAlternative_names());
		gameT.setUrl(game.getUrl());
		gameT.setSummary(game.getSummary());
		gameT.setGame(FormatList.changeToString(InteractWithIGDB.getTypeString("games", game.getGame())));
		gameT.setStoryline(game.getStoryline());
		if (game.getDevelopers()!=null)
			gameT.setDevelopers(InteractWithIGDB.getTypeString("companies", game.getDevelopers()));
		if (game.getPublishers()!=null)
			gameT.setPublishers(InteractWithIGDB.getTypeString("companies", game.getPublishers()));
		if (game.getGame_engines()!=null)
			gameT.setGame_engines(InteractWithIGDB.getTypeString("game_engines", game.getGame_engines()));
		gameT.setCategory(transferCategory(game.getCategory()));
		// gameT.setIGNScore(iGNScore);
		// gameT.setIGNComment(iGNComment);
		// gameT.setOurScore();
		// gameT.setScoreNumber(scoreNumber);
		gameT.setAggregated_rating(game.getAggregated_rating());
		if (game.getGame_modes()!=null)
			gameT.setGame_modes(InteractWithIGDB.getTypeString("game_modes", game.getGame_modes()));
		if (game.getKeywords()!=null)
			gameT.setKeywords(InteractWithIGDB.getTypeString("keywords", game.getKeywords()));
		if (game.getThemes()!=null)
			gameT.setThemes(InteractWithIGDB.getTypeString("themes", game.getThemes()));
		if (game.getGenres()!=null)
			gameT.setGenres(InteractWithIGDB.getTypeString("genres", game.getGenres()));
		gameT.setFirst_release_date(FormatTime.changeToSimpleDate(game.getFirst_release_date()));
		if (game.getRelease_dates()!=null)
			gameT.setRelease_dates(transferRelease_date(game.getRelease_dates()));
		if (game.getScreenshots()!=null)
			gameT.setScreenshots(transferScreenshot(game.getScreenshots(), "screenshot_med"));
		if (game.getVideos()!=null)
			gameT.setVideos(transferVideo(game.getVideos()));
		gameT.setCover(transferCover(game.getCover(), "cover_big"));
	}

//	public static void main(String[] args) {
//		String str = InteractWithIGDB.getGameList("fallout", 0, 1);
//		JsonParser parser = new JsonParser();
//
//		// JsonParser can transfer a string with json format into
//		// JsonElement
//		JsonElement el = parser.parse(str);
//
//		// JsonElement===>>>JsonObject
//		// JsonObject jsonObj = null;
//		// if(el.isJsonObject()){
//		// jsonObj = el.getAsJsonObject();
//		// }
//
//		// JsonElement===>>>JsonArray
//		JsonArray jsonArray = null;
//		if (el.isJsonArray()) {
//			jsonArray = el.getAsJsonArray();
//		}
//		// System.out.println(responseCount.getBody());
//		// System.out.println(response.getBody());
//		// System.out.println("{\"gameCount\":"+responseCount.getBody()+",\"gameDetail\":"+response.getBody()+"}");
//
//		// traversal the list
//		List<Game> gameList = new ArrayList<Game>();
//		Game game = new Game();
//		Iterator it = jsonArray.iterator();
//		Gson gson = new Gson();
//		while (it.hasNext()) {
//			JsonElement e = (JsonElement) it.next();
//			// JsonElement===>>>JavaBean
//			game = gson.fromJson(e, Game.class);
//			gameList.add(game);
//		}
//		GameT gameT = new GameT();
//		transferGame(gameList.get(0), gameT);
//		System.out.println(gson.toJson(gameT));
//	}
}
