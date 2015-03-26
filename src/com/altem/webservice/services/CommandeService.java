package com.altem.webservice.services;


import java.util.List;



import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


import javax.ws.rs.core.Context;


import javax.ws.rs.core.SecurityContext;



import com.altem.webservice.entities.Commande;
import com.altem.webservice.repositeries.UserDAO;
import com.altem.webservice.repositeries.CommandeDAO;

@Path("/api/user/commande")
@Produces({"application/json; charset=UTF-8","text/xml"})
@Stateless
public class CommandeService {
	
	@EJB 
	private CommandeDAO commandeDAO;
	
	@EJB 
	private UserDAO clientDAO;
	
	
	 @Context
	 SecurityContext securityContext;
	
	
	@Path("/list")  
    @GET
    @RolesAllowed("ADMIN")
    public List<Commande> list(@QueryParam("first") @DefaultValue("0") int first,
                           @QueryParam("max") @DefaultValue("200") int max) {
		
        return commandeDAO.list(first, max);
    }
	
	@Path("/{num}/{numOrdre}") 
	@GET
	@RolesAllowed("ADMIN")
	public Commande getCommande(@PathParam("num") int num,@PathParam("numOrdre") int numOrdre){
		
		return commandeDAO.find(num, numOrdre);
	}
	  
	
	@GET
	@RolesAllowed({"ADMIN","USER"})
	public List<Commande> getCommandesClient(){
		String client=clientDAO.getClientName(securityContext.getUserPrincipal().getName());
		
		return commandeDAO.listCommandeClient(client);			
	}
			

}
