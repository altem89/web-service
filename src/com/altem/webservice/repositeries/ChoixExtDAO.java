package com.altem.webservice.repositeries;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.altem.webservice.entities.ChoixExt;

@Stateless
public class ChoixExtDAO {
	
	@EJB
	private DAO dao;
	
	@SuppressWarnings("unchecked")
	public List<ChoixExt> listLibreart(){
		return (List<ChoixExt>) dao.getEntityManager().createNamedQuery("choixExtLibreArt.list").getResultList();
	}

}
