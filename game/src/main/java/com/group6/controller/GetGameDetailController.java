package com.group6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetGameDetailController {
	@RequestMapping("/getGameDetail")
	public ModelAndView SearchController() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("gameDetail");
		return modelAndView;
	}
}
