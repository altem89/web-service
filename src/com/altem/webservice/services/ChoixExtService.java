package com.altem.webservice.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;



import com.altem.webservice.entities.ChoixExt;
import com.altem.webservice.repositeries.ChoixExtDAO;

@Path("/api/choix-ext")
@Produces({"application/json; charset=UTF-8","text/xml"})
@Stateless
public class ChoixExtService {
	
	@EJB
	private ChoixExtDAO choixExtDAO;
	
	@GET
	@Path("/list-libreart")
	public List<ChoixExt> listLibreart(){
		return choixExtDAO.listLibreart();
	}

}
