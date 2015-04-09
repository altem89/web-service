package com.altem.webservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

@Entity
@Table(name="ARTICLETIERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "articleTiers.list", query = "select a from ArticleTiers a where a.refTiers=:clientCode ")
   
})
@Cache(
		type=CacheType.SOFT,
		size=64000,
		expiry=360000,   //6 minutes
		coordinationType=CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS )

public class ArticleTiers {
	
	@Id
	@Column(name="GAT_ARTICLE")
	@Size(max=35)
	private String gatArticle;
	
	@Column(name="GAT_REFTIERS")
	@Size(max=17)
	private String refTiers;
	
	@Column(name="GAT_REFARTICLE")
	@Size(max=35)
	private String refArticle;
	
	@Column(name="GAT_LIBELLE")
	@Size(max=70)
	private String libelleArticle;

	public String getGatArticle() {
		return gatArticle;
	}

	public void setGatArticle(String gatArticle) {
		this.gatArticle = gatArticle;
	}

	public String getRefTiers() {
		return refTiers;
	}

	public void setRefTiers(String refTiers) {
		this.refTiers = refTiers;
	}

	public String getRefArticle() {
		return refArticle;
	}

	public void setRefArticle(String refArticle) {
		this.refArticle = refArticle;
	}

	public String getLibelleArticle() {
		return libelleArticle;
	}

	public void setLibelleArticle(String libelleArticle) {
		this.libelleArticle = libelleArticle;
	}

}
