package ttu.idu0080.rest.controller;

import java.io.IOException;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ttu.idu0080.rest.service.*;
import ttu.idu0080.rest.data.*;


@Controller
public class RESTController {
	
	@Autowired
	private DataService dataService;


	@RequestMapping(value="/service/guitars",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Guitar> getGuitars(HttpServletResponse response) throws IOException{
		
		List<Guitar> guitars = dataService.getAllGuitars();
		return guitars;
	}
	
	
}
