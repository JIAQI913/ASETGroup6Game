package com.group6.data.entity;

import java.util.List;
/**
 * Class about transfered game(change all private members to be String).
 * 
 * @author Qihui Fan
 *
 */
public class GameT {
	private int id;
	private String name;
	private List<Alternative_name> alternative_names;
	private String url;
	private String summary;
	private String game;
	private String storyline;
	private List<String> developers;
	private List<String> publishers;
	private List<String> game_engines;
	private String category;
	private double IGNScore;
	private String IGNComment;
	private double ourScore;
	private int scoreNumber;
	private double aggregated_rating;
	private List<String> game_modes;
	private List<String> keywords;
	private List<String> themes;
	private List<String> genres;
	private String first_release_date;
	private List<Release_dateT> release_dates;
	private List<ScreenshotT> screenshots;
	private List<VideoT> videos;
	private CoverT cover;
	
	public double getAggregated_rating() {
		return aggregated_rating;
	}
	public void setAggregated_rating(double aggregated_rating) {
		this.aggregated_rating = aggregated_rating;
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
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public String getStoryline() {
		return storyline;
	}
	public void setStoryline(String storyline) {
		this.storyline = storyline;
	}
	public List<String> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<String> developers) {
		this.developers = developers;
	}
	public List<String> getPublishers() {
		return publishers;
	}
	public void setPublishers(List<String> publishers) {
		this.publishers = publishers;
	}
	public List<String> getGame_engines() {
		return game_engines;
	}
	public void setGame_engines(List<String> game_engines) {
		this.game_engines = game_engines;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getIGNScore() {
		return IGNScore;
	}
	public void setIGNScore(double iGNScore) {
		IGNScore = iGNScore;
	}
	public String getIGNComment() {
		return IGNComment;
	}
	public void setIGNComment(String iGNComment) {
		IGNComment = iGNComment;
	}
	public double getOurScore() {
		return ourScore;
	}
	public void setOurScore(double ourScore) {
		this.ourScore = ourScore;
	}
	public int getScoreNumber() {
		return scoreNumber;
	}
	public void setScoreNumber(int scoreNumber) {
		this.scoreNumber = scoreNumber;
	}
	public List<String> getGame_modes() {
		return game_modes;
	}
	public void setGame_modes(List<String> game_modes) {
		this.game_modes = game_modes;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public List<String> getThemes() {
		return themes;
	}
	public void setThemes(List<String> themes) {
		this.themes = themes;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public String getFirst_release_date() {
		return first_release_date;
	}
	public void setFirst_release_date(String first_release_date) {
		this.first_release_date = first_release_date;
	}
	public List<Release_dateT> getRelease_dates() {
		return release_dates;
	}
	public void setRelease_dates(List<Release_dateT> release_dates) {
		this.release_dates = release_dates;
	}
	public List<ScreenshotT> getScreenshots() {
		return screenshots;
	}
	public void setScreenshots(List<ScreenshotT> screenshots) {
		this.screenshots = screenshots;
	}
	public List<VideoT> getVideos() {
		return videos;
	}
	public void setVideos(List<VideoT> videos) {
		this.videos = videos;
	}
	public CoverT getCover() {
		return cover;
	}
	public void setCover(CoverT cover) {
		this.cover = cover;
	}
	
}
