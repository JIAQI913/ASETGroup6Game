package com.group6.data.entity;

/**
 * Class about game's video.
 * 
 * @author Qihui Fan
 *
 */
public class Video {
	private String name;
	private String video_id;
	
	public Video(){
		name="null";
		video_id="null";
	}
	public Video(String name, String video_id) {
		this.name = name;
		this.video_id = video_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVideo_id() {
		return video_id;
	}
	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}
	
}
