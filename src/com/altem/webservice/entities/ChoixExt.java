package com.altem.webservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;


@Entity
@Table(name="CHOIXEXT")
@XmlRootElement
@NamedQueries({
    
    @NamedQuery(name="choixExtLibreArt.list", query="select c from ChoixExt c where c.type like 'LA%'")
})
@Cache(
		type=CacheType.SOFT,
		size=64000,
		expiry=7200000,   //2 heures
		coordinationType=CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS)

@IdClass(ChoixExtPK.class)
public class ChoixExt {
	
	@Id
	@Column(name="YX_CODE")
	@Size(max=17)
	private String code;
	
	@Id
	@Column(name="YX_TYPE")
	@Size(max=3)
	private String type;
	
	@Column(name="YX_LIBELLE")
	@Size(max=105)
	private String libelle;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
