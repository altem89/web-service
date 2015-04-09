package com.altem.webservice.services;

import java.math.BigDecimal;
import java.util.List;


import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.altem.webservice.entities.Article; 
import com.altem.webservice.repositeries.ArticleDAO;


@Path("/api/article")
@Produces({"application/json; charset=UTF-8","text/xml"})
@Stateless
public class ArticleService {
	
	@EJB
	private ArticleDAO articleDAO;
	
	
	@Path("/{id}")
	@GET
	public Article getArticle(@PathParam("id") String id){
		try{
		return articleDAO.getArticle(id);
		}catch(javax.ejb.EJBTransactionRolledbackException e){
			throw new IllegalArgumentException("article with id:"+id+" not found");
		}
	}
	
	@Path("/type/{type}")
	@GET
	public List<Article> listArticleType(@PathParam("type") String type){
		return articleDAO.listArticleType(type);
	}
	
	
	@Path("/familleniv1")
	@GET
	public String listFamilleniv1(){
		return articleDAO.listFamilleniv1().toString();
	}
	
	@Path("/familleniv1/{famille}")
	@GET
	public List<Article> listArticleFamilleniv1(@PathParam("famille") String fam){
		return articleDAO.listArticleFamilleniv1(fam);
	}
	
	@Path("/familleniv2")
	@GET
	public String listFamilleniv2(){
		return articleDAO.listFamilleniv2().toString();
	}
	
	@Path("/familleniv2/{famille}")
	@GET
	public List<Article> listArticleFamilleniv2(@PathParam("famille") String fam){
		return articleDAO.listArticleFamilleniv2(fam);
	}
	
	@Path("/familleniv3")
	@GET
	public String listFamilleniv3(){
		return articleDAO.listFamilleniv3().toString();
	}
	
	@Path("/familleniv3/{famille}")
	@GET
	public List<Article> listArticleFamilleniv3(@PathParam("famille") String fam){
		return articleDAO.listArticleFamilleniv3(fam);
	}
	
	@Path("/libreart1")
	@GET
	public String libreart1(){
		return articleDAO.listLibreart1().toString();
	}
	
	@Path("/libreart1/{libreart}")
	@GET
	public List<Article> libreart1(@PathParam("libreart") String lib){
		return articleDAO.listArticleLibreart1(lib);
	}
	
	
	
	@Path("/libreart2")
	@GET
	public String libreart2(){
		return articleDAO.listLibreart2().toString();
	}
	
	@Path("/libreart2/{libreart}")
	@GET
	public List<Article> libreart2(@PathParam("libreart") String lib){
		return articleDAO.listArticleLibreart2(lib);
	}
	
	@Path("/libreart3")
	@GET
	public String libreart3(){
		return articleDAO.listLibreart3().toString();
	}
	
	@Path("/libreart3/{libreart}")
	@GET
	public List<Article> libreart3(@PathParam("libreart") String lib){
		return articleDAO.listArticleLibreart3(lib);
	}
	
	@Path("/vallibre1/{num}")
	@GET
	
	public List<Article> getAllVallibre1(@PathParam("num") BigDecimal val){
		return articleDAO.getAllVallibre1(val);
	}
	
	@Path("/list")
    @GET
    
    public List<Article> list(@QueryParam("first") @DefaultValue("0") int first,
                           @QueryParam("max") @DefaultValue("100") int max) {
        return articleDAO.list(first, max);
    }
	
	@Path("/list-en-stock")
	@GET
	
	public List<Article> listEnStock(){
		return articleDAO.listArticleEnStock();
	}
	
	@Path("/{id}")
	@PUT
	@RolesAllowed("ADMIN")
	public Article create(@QueryParam("idX") String id,@PathParam("id") String codeWithoutX,
			             @QueryParam("libelle") String libelle,@QueryParam("type") String type){
	
		return articleDAO.create(id,codeWithoutX,libelle,type);
		
	}
	
	
	@POST
	@RolesAllowed("ADMIN")
	public Article update(@FormParam("id") String id,@FormParam("libelle") String libelle,@FormParam("type") String type){
		return articleDAO.update(id, libelle,type);
	}
	
	@Path("/{id}")
	@DELETE
	@RolesAllowed("ADMIN")
	public void delete(@PathParam("id") String id){
		articleDAO.delete(id);
	}

}

