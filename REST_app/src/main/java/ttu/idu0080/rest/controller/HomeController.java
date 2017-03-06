package ttu.idu0080.rest.controller;

import java.io.IOException;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;

import ttu.idu0080.rest.service.*;
import ttu.idu0080.rest.data.*;

@Controller
public class HomeController {
	
	@Autowired
	private DataService dataService;

	@RequestMapping(value="/test")
	public ModelAndView goTestPage(Model firm) throws IOException{
		List<Guitar> guitars = dataService.getAllGuitars();
		 firm.addAttribute("guitars",  guitars);
		return new ModelAndView("test");
	}
	
	@RequestMapping(value="/")
	public ModelAndView goHomePage(Model model) throws IOException{

		return new ModelAndView("home");
	}
	
}
