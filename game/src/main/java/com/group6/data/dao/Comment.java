package com.group6.data.dao;

public class Comment {

	private int GID;
	private String score_phrase;
	private String title;
	private String platform;
	private double score;
	private int count;
	
	public int getGID() {
		return GID;
	}
	public void setGID(int gID) {
		GID = gID;
	}
	public String getScore_phrase() {
		return score_phrase;
	}
	public void setScore_phrase(String score_phrase) {
		this.score_phrase = score_phrase;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}