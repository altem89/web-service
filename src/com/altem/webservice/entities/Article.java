package com.altem.webservice.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

@Entity
@Table(name="ARTICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "article.list", query = "select a from Article a"),
    @NamedQuery(name="article.get", query="select a from Article a where a.codeArticleWithoutX=:codeArticle"),
    @NamedQuery(name="articleType.get",query="select a from Article a where a.type=:type"),
    @NamedQuery(name="familleniv1.get" , query="select distinct a.familleniv1 from Article a"),
    @NamedQuery(name="familleniv1.list" , query="select a from Article a where a.familleniv1=:fam"),
    @NamedQuery(name="familleniv2.get" , query="select distinct a.familleniv2 from Article a"),
    @NamedQuery(name="familleniv2.list" , query="select a from Article a where a.familleniv2=:fam"),
    @NamedQuery(name="familleniv3.get" , query="select distinct a.familleniv3 from Article a"),
    @NamedQuery(name="familleniv3.list" , query="select a from Article a where a.familleniv3=:fam"),
    @NamedQuery(name="libreart1.get" , query="select distinct a.libreart1 from Article a"),
    @NamedQuery(name="libreart1.list" , query="select a from Article a where a.libreart1=:libr"),
    @NamedQuery(name="libreart2.get" , query="select distinct a.libreart2 from Article a"),
    @NamedQuery(name="libreart2.list" , query="select a from Article a where a.libreart2=:libr"),
    @NamedQuery(name="libreart3.get" , query="select distinct a.libreart3 from Article a"),
    @NamedQuery(name="libreart3.list" , query="select a from Article a where a.libreart3=:libr"),
    @NamedQuery(name="vallibre1Spec.getAll", query="select a from Article a where cast(a.vallibre1 as varchar) like :val")
})
@Cache(
		type=CacheType.SOFT,
		size=64000,
		expiry=3600000,   //60 minutes
		coordinationType=CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS)

public class Article {
	
	@Id	
	@Size(max=35)
	@Column(name="GA_ARTICLE")
	@NotNull
	private String id;
	
	@Column(name="GA_CODEARTICLE")
	@Size(max=18)
	private String codeArticleWithoutX;
	
	
	@Size(max=70)
	@Column(name="GA_LIBELLE")
	private String libelle;
	
	
	@Size(max=3)
	@Column(name="GA_TYPEARTICLE")
	private String type;
	
	@Column(name="GA_FAMILLENIV1")
	@Size(max=3)
	private String familleniv1; 
	
	@Column(name="GA_FAMILLENIV2")
	@Size(max=3)
	private String familleniv2;
	
	@Column(name="GA_FAMILLENIV3")
	@Size(max=3)
	private String familleniv3;
	
	@Column(name="GA_LIBREART1")
	@Size(max=6)
	private String libreart1; 
	
	@Column(name="GA_LIBREART2")
	@Size(max=6)
	private String libreart2;
	
	@Column(name="GA_LIBREART3")
	@Size(max=6)
	private String libreart3;
	
	@Column(name="GA_VALLIBRE1")
	@Digits(integer=19,fraction=4)
	private BigDecimal vallibre1;
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public void setCodeArticleWithoutX(String codeArticle){
		this.codeArticleWithoutX=codeArticle;
	}
	
	public String getCodeArticleWithoutX(){
		return codeArticleWithoutX;
	}
	
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type=type;
	}
	
	
	public String getLibelle(){
		return libelle;	
	}
	
	public void setLibelle(String libelle){	
		this.libelle=libelle;
	}

	public String getFamilleniv1() {
		return familleniv1;
	}

	public void setFamilleniv1(String familleniv1) {
		this.familleniv1 = familleniv1;
	}

	public String getFamilleniv2() {
		return familleniv2;
	}

	public void setFamilleniv2(String familleniv2) {
		this.familleniv2 = familleniv2;
	}

	public String getFamilleniv3() {
		return familleniv3;
	}

	public void setFamilleniv3(String familleniv3) {
		this.familleniv3 = familleniv3;
	}

	public String getLibreart1() {
		return libreart1;
	}

	public void setLibreart1(String libreart1) {
		this.libreart1 = libreart1;
	}

	public String getLibreart2() {
		return libreart2;
	}

	public void setLibreart2(String libreart2) {
		this.libreart2 = libreart2;
	}

	public String getLibreart3() {
		return libreart3;
	}

	public void setLibreart3(String libreart3) {
		this.libreart3 = libreart3;
	}

	public BigDecimal getVallibre1() {
		if(vallibre1==null) return  BigDecimal.valueOf(0,4);
		return vallibre1;
	}

	public void setVallibre1(BigDecimal vallibre1) {
		this.vallibre1 = vallibre1;
	}
	

}

