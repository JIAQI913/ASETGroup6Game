package com.group6.data.entity;

import java.util.List;

/**
 * Class about game.
 * 
 * @author Qihui Fan
 *
 */
public class Game {
	private int id;
	private String name;
	private List<Alternative_name> alternative_names;
	private String url;
	private String summary;
	private int game;
	private String storyline;
	private List<Integer> developers;
	private List<Integer> publishers;
	private List<Integer> game_engines;
	private int category;
//	private double IGNScore;
//	private double ourScore;
//	private int scoreNumber;
	private double aggregated_rating;
	private List<Integer> game_modes;
	private List<Integer> keywords;
	private List<Integer> themes;
	private List<Integer> genres;
	private long first_release_date;
	private List<Release_date> release_dates;
	private List<Screenshot> screenshots;
	private List<Video> videos;
	private Cover cover;
	
	public Game(){
		summary="";
		storyline="";
		screenshots=null;
		release_dates=null;
		videos=null;
		game_engines=null;
		developers=null;
		publishers=null;
		game_modes=null;
		alternative_names=null;
		keywords=null;
		themes=null;
		genres=null;
	}
	public double getAggregated_rating() {
		return aggregated_rating;
	}

	public void setAggregated_rating(double aggregated_rating) {
		this.aggregated_rating = aggregated_rating;
	}

	public int getGame() {
		return game;
	}

	public void setGame(int game) {
		this.game = game;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Alternative_name> getAlternative_names() {
		return alternative_names;
	}

	public void setAlternative_names(List<Alternative_name> alternative_names) {
		this.alternative_names = alternative_names;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getStoryline() {
		return storyline;
	}

	public void setStoryline(String storyline) {
		this.storyline = storyline;
	}

	public List<Integer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Integer> developers) {
		this.developers = developers;
	}

	public List<Integer> getPublishers() {
		return publishers;
	}

	public void setPublishers(List<Integer> publishers) {
		this.publishers = publishers;
	}

	public List<Integer> getGame_engines() {
		return game_engines;
	}

	public void setGame_engines(List<Integer> game_engines) {
		this.game_engines = game_engines;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

//	public double getIGNScore() {
//		return IGNScore;
//	}
//
//	public void setIGNScore(double iGNScore) {
//		IGNScore = iGNScore;
//	}
//
//	public double getOurScore() {
//		return ourScore;
//	}
//
//	public void setOurScore(double ourScore) {
//		this.ourScore = ourScore;
//	}
//
//	public int getScoreNumber() {
//		return scoreNumber;
//	}
//
//	public void setScoreNumber(int scoreNumber) {
//		this.scoreNumber = scoreNumber;
//	}

	public List<Integer> getGame_modes() {
		return game_modes;
	}

	public void setGame_modes(List<Integer> game_modes) {
		this.game_modes = game_modes;
	}

	public List<Integer> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Integer> keywords) {
		this.keywords = keywords;
	}

	public List<Integer> getThemes() {
		return themes;
	}

	public void setThemes(List<Integer> themes) {
		this.themes = themes;
	}

	public List<Integer> getGenres() {
		return genres;
	}

	public void setGenres(List<Integer> genres) {
		this.genres = genres;
	}

	public long getFirst_release_date() {
		return first_release_date;
	}

	public void setFirst_release_date(long first_release_date) {
		this.first_release_date = first_release_date;
	}

	public List<Release_date> getRelease_dates() {
		return release_dates;
	}

	public void setRelease_dates(List<Release_date> release_dates) {
		this.release_dates = release_dates;
	}

	public List<Screenshot> getScreenshots() {
		return screenshots;
	}

	public void setScreenshots(List<Screenshot> screenshots) {
		this.screenshots = screenshots;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Cover getCover() {
		return cover;
	}

	public void setCover(Cover cover) {
		this.cover = cover;
	}

}