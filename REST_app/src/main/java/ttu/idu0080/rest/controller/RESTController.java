package ttu.idu0080.rest.controller;

import java.io.IOException;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.transaction.annotation.Transactional;

import ttu.idu0080.rest.service.*;
import ttu.idu0080.rest.data.*;


@Controller
public class RESTController {
	
	@Autowired
	private DataService dataService;
	@Autowired
	private RESTDataService restDataService;

	@RequestMapping(value="/service/guitars",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Guitar> getGuitars(HttpServletResponse response) throws IOException{
		
		List<Guitar> guitars = dataService.getAllGuitars();
		return guitars;
	}
	
	@RequestMapping(value="/service/guitar/{id}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Guitar getGuitar(@PathVariable int id) throws IOException{
		
		Guitar guitar = dataService.getGuitarById(id);
		return guitar;
	}
	
	@Transactional
	@RequestMapping(value = "/service/guitar/{id}", method=RequestMethod.POST)
	public @ResponseBody void updateGuitar(@RequestBody Guitar Guitar)
	{
		dataService.update(Guitar);
	}
	
	@Transactional
	@RequestMapping(value = "/service/guitar/{id}", method=RequestMethod.DELETE)
	public @ResponseBody void deleteGuitar(@PathVariable int id)
	{
		dataService.delete(id);
	}
	
	@Transactional
	@RequestMapping(value = "/service/guitar/", method=RequestMethod.PUT)
	public @ResponseBody void insertGuitar(@RequestBody Guitar guitar)
	{
		dataService.save(guitar);
	}

	
	@RequestMapping(value="/service/external/guitars",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Guitar> getExternalGuitars(HttpServletResponse response) throws IOException{
		List<Guitar> guitars = restDataService.getAllGuitars();
		return guitars;
	}
	
	@RequestMapping(value="/service/search",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Guitar> searchGuitars(@RequestParam(value = "firm") String firm) throws IOException{
		List<Guitar> guitars= dataService.searchByFirm(firm);
		return guitars;
	}

	
}
