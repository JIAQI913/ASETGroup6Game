package com.group6.data.entity;

/**
 * Class about game's screenshot.
 * 
 * @author Qihui Fan
 *
 */
public class Screenshot {
	private String cloudinary_id;
	private int width;
	private int height;
	
	public Screenshot(String cloudinary_id, int width, int height) {
		super();
		this.cloudinary_id = cloudinary_id;
		this.width = width;
		this.height = height;
	}
	public String getCloudinary_id() {
		return cloudinary_id;
	}
	public void setCloudinary_id(String cloudinary_id) {
		this.cloudinary_id = cloudinary_id;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
