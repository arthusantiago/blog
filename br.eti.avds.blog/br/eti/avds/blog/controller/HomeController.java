package br.eti.avds.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
    
	@RequestMapping("/home")
	public String index(Model model) {
		return "/page/home";
	}

}
