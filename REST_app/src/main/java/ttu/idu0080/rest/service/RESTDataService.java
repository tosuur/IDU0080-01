package ttu.idu0080.rest.service;

import ttu.idu0080.rest.data.*;

import java.util.*;
import java.util.List;

import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;;
@Service
public class RESTDataService  {



	
	
	public List<Guitar> getAllGuitars()  {
		
		Guitar[] guitar_array = null;
		try
		{
			RestTemplate restTemplate = new RestTemplate();
		guitar_array = restTemplate.getForObject("http://localhost:8080/REST_service/service/guitars", Guitar[].class) ;
		System.out.println("Kitarre REST-teenusest:" + guitar_array.length);
		}
		catch(Exception ex)
		{
			System.out.println("RESTDataService.getAllGuitars():"+ ex.getMessage());
		}

		List<Guitar> guitar_list= Arrays.asList(guitar_array);
		return guitar_list;
	}

	
	
	
}
