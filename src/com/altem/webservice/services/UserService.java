package com.altem.webservice.services;

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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import com.altem.webservice.entities.User;
import com.altem.webservice.repositeries.UserDAO;

@Stateless
@Path("/api/user")
@Produces({"application/json; charset=UTF-8","text/xml"})
public class UserService {
	
	@EJB
	private UserDAO clientDAO;
	
	@Context
	SecurityContext sc;
	
	@Path("/")
	@POST
	@RolesAllowed("ADMIN")
	public User createClient(@FormParam("username") String user,@FormParam("client") String clientUser,
			                   @FormParam("password") String password,@FormParam("role")String role){
		
		return clientDAO.create(user, clientUser, password, role);
		
	}
	
	@Path("/{username}")
	@DELETE
	@RolesAllowed("ADMIN")
	public void delete(@PathParam("username") String user){
		clientDAO.delete(user);
	}
	
	@Path("/{username}/{password}")
	@GET
	@RolesAllowed("ADMIN")
	public User getUser(@PathParam("username") String username,@PathParam("password") String password){
		return clientDAO.getClient(username,password);
	}
	
	@Path("/{username}")
	@PUT
	@RolesAllowed("USER")
	public User update(@PathParam("username") String username,@QueryParam("password") String password){
		return clientDAO.update(username, password);
	}
	
	@GET
	@Path("/list")
	@RolesAllowed("ADMIN")
	public List<User> list(@QueryParam("first") @DefaultValue("0") int first,
                           @QueryParam("max") @DefaultValue("100") int max){
		return clientDAO.list(first, max);
	}
	
	

}
