package com.altem.webservice.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

@Entity
@Table(name="LIGNE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "commande.list", query = "select c from Commande c where c.naturePiece='CC' "),
    
    @NamedQuery(name="commandeClient.list", query="select c from Commande c where c.naturePiece='CC' and c.client=:name")
})
@Cache(
		type=CacheType.SOFT,
		size=64000,
		expiry=60000,   //1 minute
		coordinationType=CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS)

@IdClass(CommandePK.class)
public class Commande {
	
	@Id
	@Column(name="GL_NUMERO")
	private int numero;
	
	@Id
	@Column(name="GL_NUMORDRE")
	private int numeroOrdre;
	
	@Column(name="GL_TIERSFACTURE")
	@Size(max=17)
	private String client;
	
	@Size(max=3)
	@Column(name="GL_NATUREPIECEG")
	private String naturePiece;
	
	@Size(max=70)
	@Column(name="GL_LIBELLE")
	private String libelleArticle;
	
	@Size(max=35)
	@Column(name="GL_LIBCOMPL")
	private String libCompl;
	
	@Size(max=3)
	@Column(name="GL_SOUCHE")
	private String souche;
	
	@Column(name="GL_MONTANTHT")
	@Digits(integer=19,fraction=4)
	private BigDecimal montantHT=BigDecimal.ZERO;
	
	@Column(name="GL_MONTANTTTC")
	@Digits(integer=19,fraction=4)
	private BigDecimal montantTTC=BigDecimal.ZERO;
	
	@Column(name="GL_DEVISE")
	@Size(max=3)
	private String devise;
	
	@Column(name="GL_DATECREATION")
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	
	public int getNumero(){
		return numero;
	}
	
	public void setNumero(int num){
		this.numero=num;
	}

	public int getNumeroOrdre() {
		return numeroOrdre;
	}

	public void setNumeroOrdre(int numeroOrdre) {
		this.numeroOrdre = numeroOrdre;
	}


	public String getLibelleArticle() {
		return libelleArticle;
	}

	public void setLibelleArticle(String libelleArticle) {
		this.libelleArticle = libelleArticle;
	}

	public String getLibCompl() {
		return libCompl;
	}

	public void setLibCompl(String libCompl) {
		this.libCompl = libCompl;
	}

	public String getSouche() {
		return souche;
	}

	public void setSouche(String souche) {
		this.souche = souche;
	}

	public BigDecimal getMontantHT() {
		if(montantHT==null) return  BigDecimal.valueOf(0,4);
		return montantHT;
	}

	public void setMontantHT(BigDecimal montantHT) {
		this.montantHT = montantHT;
	}

	public BigDecimal getMontantTTC() {
		if(montantTTC==null) return  BigDecimal.valueOf(0,4);
		return montantTTC;
	}

	public void setMontantTTC(BigDecimal montantTTC) {
		this.montantTTC = montantTTC;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getNaturePiece() {
		return naturePiece;
	}

	public void setNaturePiece(String naturePiece) {
		this.naturePiece = naturePiece;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
	

}
