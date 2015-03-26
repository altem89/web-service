package com.altem.webservice.repositeries;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.altem.webservice.entities.User;

@Stateless
public class UserDAO {
	
	@EJB
	private DAO dao;
	
	public User create(String user,String clientUser,String password,String role){
		User client=new User();
		client.setUsername(user);
		client.setUsernameRoleTable(user);
		client.setClientUser(clientUser);
		client.setPassword(password);
		client.setRole(role);
		return dao.create(client);
	}
	
	public User update(String username,String password){
		User client=dao.find(User.class,username);
		if(client==null){
			throw new IllegalArgumentException("unknowned user");
		}
		client.setPassword(password);
		return dao.update(client);
	}
	
	public void delete(String username){
		User client=dao.find(User.class,username);
		if(client==null){
			throw new IllegalArgumentException("unknowned user");
		}
		dao.delete(User.class,username);
	}
	
	public String getClientName(String username){
		User client=dao.find(User.class,username);
		if(client==null){
			throw new IllegalArgumentException("unknowned user");
		}
		return client.getClientUser();
	}
	
	public List<User> list(int min,int max){
		return dao.namedFind(User.class, "user.list", min, max);
	}
	
	public User getClient(String username,String password){
		return (User) dao.getEntityManager().createNamedQuery("userCompte.get").setParameter("login", username)
				.setParameter("pass", password).getSingleResult();
	}

}
