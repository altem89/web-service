package com.altem.webservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

@Entity
@Table(name="WEBSERVICE_USERS")
@SecondaryTable(name="WEBSERVICE_ROLES_USERS",
pkJoinColumns={
 @PrimaryKeyJoinColumn(name="USERNAME")
})
@NamedQueries({
    @NamedQuery(name = "user.list", query = "select u from User u"),
    @NamedQuery(name="userCompte.get", query="select u from User u where u.username=:login and u.password=:pass")
})
@XmlRootElement
@Cache(
		type=CacheType.SOFT,
		size=64000,
		expiry=60000,   //1 minute
		coordinationType=CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS)
public class User {
	
	@Id
	@Column(name="USERNAME",table="WEBSERVICE_USERS")
	@Size(max=50)
	@NotNull
	private String username;
	
	@Column(name="USERNAME",table="WEBSERVICE_ROLES_USERS")
	@NotNull
	private String usernameRoleTable;
	
	@Column(name="CLIENT_USER",table="WEBSERVICE_USERS")
	@Size(max=17)
	@NotNull
	private String clientUser;
	
	@Column(name="PASSWORD",table="WEBSERVICE_USERS")
	@Size(max=50)
	@NotNull
	private String password;
	
	@Column(name="ROLE",table="WEBSERVICE_ROLES_USERS")
	@Size(max=15)
	@NotNull
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClientUser() {
		return clientUser;
	}

	public void setClientUser(String client) {
		this.clientUser = client;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsernameRoleTable() {
		return usernameRoleTable;
	}

	public void setUsernameRoleTable(String usernameRoleTable) {
		this.usernameRoleTable = usernameRoleTable;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	

}
