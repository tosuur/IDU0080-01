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


	public Guitar getGuitarById(long id)  {


		Guitar node = null;
		try {


			Query q =  em
					.createQuery(
							"select g from Guitar g where g.id = :id")
							.setParameter("id", id);
			node = (Guitar) q.getSingleResult();


		}

		catch(Exception ex)
		{
			System.out.println("DataService.getGuitarById():"+ ex.getMessage());
		
		}

		return node;
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

	
	
	public Guitar update(Guitar guitar)  {


		System.out.println("guitar update , guitar Firm: " + guitar.getFirm());
		try {

			em.merge(guitar);
			em.flush();

		}

		catch(Exception ex)
		{
			System.out.println("DataService.update():"+ ex.getMessage());
		}

		return guitar;
	}

	
	public Guitar save(Guitar guitar) {

		System.out.println("new guitar insert , guitar Firm: " + guitar.getFirm());

		try {
			
			em.persist(guitar);


		}

		catch(Exception ex)
		{
			System.out.println("DataService.save():"+ ex.getMessage());
		}

		return guitar;
	}
	
	public void delete(long id) {

		System.out.println("DELETE ");

		try {
			
	          Guitar guitar =  em.find(Guitar.class,id);
	          em.remove(guitar);


		}

		catch(Exception ex)
		{
			System.out.println("DataService.delete():"+ ex.getMessage());
		}


	}
	
	public  List<Guitar> searchByFirm(String s_firm)  {

		List<Guitar> guitars = null;

		try {

			String sql = "from Guitar g where upper(g.firm) like upper(:firm) order by g.name";
            
			Query q = em.createQuery(sql);	
			q.setParameter("firm", s_firm+"%") ;                  
			guitars =  (List<Guitar>) q.getResultList();	 				
                        System.out.println("Otsingu tulemusi:" + guitars.size());

		}

		catch(Exception ex)
		{
			System.out.println("DataService.searchByModel():" + ex.getMessage());

		}

		return guitars;
	}
	
	
}
