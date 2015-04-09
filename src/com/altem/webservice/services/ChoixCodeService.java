package com.altem.webservice.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.altem.webservice.entities.ChoixCode;
import com.altem.webservice.repositeries.ChoixCodeDAO;

@Path("/api/choixcode")
@Produces({"application/json; charset=UTF-8","text/xml"})
@Stateless
public class ChoixCodeService {
	
	@EJB
	private ChoixCodeDAO choixCodeDAO;
	
	@GET
	@Path("/list")
	public List<ChoixCode> list(){
		return choixCodeDAO.list();
	}
	
	@GET
	@Path("/list-famille")
	public List<ChoixCode> listFamille(){
		return choixCodeDAO.listFamille();
	}

}
