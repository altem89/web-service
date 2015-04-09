package com.altem.webservice.repositeries;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.altem.webservice.entities.ChoixCode;

@Stateless
public class ChoixCodeDAO {
	
	@EJB
	private DAO dao;
	
	@SuppressWarnings("unchecked")
	public List<ChoixCode> list(){
		return (List<ChoixCode>) dao.getEntityManager().createNamedQuery("choixCode.list").getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ChoixCode> listFamille(){
		return (List<ChoixCode>) dao.getEntityManager().createNamedQuery("choixCodeFamille.list").getResultList();
	}

}
