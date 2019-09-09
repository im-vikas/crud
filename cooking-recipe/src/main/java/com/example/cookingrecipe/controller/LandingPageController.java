package com.example.cookingrecipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingPageController {
	@RequestMapping("/")
	public String landpage() {
		return "redirect:index.html";
	}
	

}
