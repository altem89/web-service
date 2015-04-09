package com.altem.webservice.services;


import java.io.File;
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


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
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
	private UserDAO userDAO;
	
	
	 @Context
	 SecurityContext securityContext;
	 
	 private static final String FACTURE_PATH="e:\\factures\\";
	
	
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
		String client=userDAO.getClientCode(securityContext.getUserPrincipal().getName());
		
		return commandeDAO.listCommandeClient(client);			
	}
	
	@Path("/facture/pdf/{num}")
	@Produces("application/pdf")
	@GET
	@RolesAllowed({"ADMIN","USER"})
	public Response getFacture(@PathParam("num") int num){
		String client=userDAO.getClientCode(securityContext.getUserPrincipal().getName());
		Long count=commandeDAO.getcountFacture(client, num);
		
		if(count>0){
		File facture=new File(FACTURE_PATH+num+".pdf");
		ResponseBuilder response= Response.ok(facture);
		response.header("Content-Disposition",
				"attachment; filename="+num+".pdf");
		
		return response.build();
		}
		else{
			return Response.status(Response.Status.NOT_FOUND).entity("Vous n'avez pas de facture numero:" +num).build();
		}
		
	}
			

}
