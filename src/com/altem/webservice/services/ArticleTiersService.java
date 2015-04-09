package com.altem.webservice.services;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import com.altem.webservice.entities.ArticleTiers;
import com.altem.webservice.repositeries.ArticleTiersDAO;
import com.altem.webservice.repositeries.UserDAO;

@Path("/api/user/article-tiers")
@Produces({"application/json; charset=UTF-8","text/xml"})
@Stateless
public class ArticleTiersService {
	
	@EJB
	private ArticleTiersDAO articleTiersDAO;
	
	@EJB
	UserDAO userDAO;
	
	@Context
	 SecurityContext securityContext;
	
	@Path("/")
	@GET
	@RolesAllowed({"ADMIN","USER"})
	public List<ArticleTiers> getAllUserArticleTiers(){
		String client=userDAO.getClientCode(securityContext.getUserPrincipal().getName());
		return articleTiersDAO.getAllUserArticleTiers(client);
	}

}
