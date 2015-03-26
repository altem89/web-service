package com.altem.webservice.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.RollbackException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.altem.webservice.entities.Stock;
import com.altem.webservice.repositeries.StockDAO;

@Path("/api/stock")
@Produces({"application/json; charset=UTF-8","text/xml"})
@Stateless
public class StockService {
	
	@EJB
	private StockDAO stockDAO;
	
	@Path("/depot/{depot}/{article}")
	@GET
	public Stock produitDepot(@PathParam("depot") String depot,@PathParam("article") String codeStockArticle){
		return stockDAO.find(depot,codeStockArticle);
	}
	
	@Path("/depot/{depot}")
	@GET
	public List<Stock> depotProduits(@PathParam("depot") String depot){
		return stockDAO.listProductDepot(depot);
	}
	
	@Path("/list")
    @GET
    public List<Stock> list(@QueryParam("first") @DefaultValue("0") int first,
                           @QueryParam("max") @DefaultValue("400") int max) {
        return stockDAO.list(first, max);
    }
	
	@Path("/{id}")
	@GET
	public Stock getStock(@PathParam("id") String id){
		try{
		return stockDAO.getStock(id);
		}catch(RollbackException e){
			throw new IllegalArgumentException("stock with id:"+id+" is not found");
		}
	}

}
