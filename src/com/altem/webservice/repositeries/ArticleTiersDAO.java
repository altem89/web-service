package com.altem.webservice.repositeries;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import com.altem.webservice.entities.ArticleTiers;

@Stateless
public class ArticleTiersDAO {
	
	@EJB
	private DAO dao;
	
	@SuppressWarnings("unchecked")
	public List<ArticleTiers> getAllArticleLikeRef(String reference){
		return (List<ArticleTiers>) dao.getEntityManager().createNamedQuery("refarticle.list").setParameter("ref", reference+"%").getResultList();
	}

}
