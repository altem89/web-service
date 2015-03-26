package com.altem.webservice.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.altem.webservice.entities.ArticleTiers;
import com.altem.webservice.repositeries.ArticleTiersDAO;

@Path("/api/articleTiers")
@Produces({"application/json; charset=UTF-8","text/xml"})
@Stateless
public class ArticleTiersService {
	
	@EJB
	private ArticleTiersDAO articleTiersDAO;
	
	@Path("/{reference}")
	@GET
	public List<ArticleTiers> getAllBeginByRefArticle(@PathParam("reference") String reference){
		return articleTiersDAO.getAllArticleLikeRef(reference);
	}

}
