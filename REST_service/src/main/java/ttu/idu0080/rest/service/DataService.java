package ttu.idu0080.rest.service;

import ttu.idu0080.rest.data.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class DataService  {




	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}


	
	public List<Guitar> getAllGuitars()  {


		List<Guitar> guitar_list = null;
		try {


			Query q =  em
					.createQuery(
							"select g from Guitar g ");
			guitar_list = (List<Guitar>)  q.getResultList();


		}

		catch(Exception ex)
		{
			System.out.println("DataService.getAllGuitars():"+ ex.getMessage());
		}

		return guitar_list;
	}

	
	
	

	
	
	
}
