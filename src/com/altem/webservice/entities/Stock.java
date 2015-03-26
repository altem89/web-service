package com.altem.webservice.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

@Entity
@Table(name="DISPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "stock.list", query = "select s from Stock s where s.stockPhysique >1 and s.depot='001'"),
    @NamedQuery(name="stockProductsDepot.list", query="select s from Stock s where s.depot=:dept"),
   
})
@Cache(
		type=CacheType.SOFT,
		size=64000,
		expiry=360000,   //6 minutes
		coordinationType=CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS)

@IdClass(StockPK.class)
public class Stock {
	
	@Id
	@Column(name="GQ_ARTICLE")
	@Size(max=35)
	private String codeStockArticle;
	
	@Id
	@Column(name="GQ_DEPOT")
	@Size(max=3)
	private String depot;
	
	@Column(name="GQ_PHYSIQUE")
	@Digits(integer=15,fraction=4)
	private BigDecimal stockPhysique=BigDecimal.ZERO;
	

	public String getCodeStockArticle() {
		return codeStockArticle;
	}

	public void setCodeStockArticle(String codeStockArticle) {
		this.codeStockArticle = codeStockArticle;
	}

	public BigDecimal getStockPhysique() {
		if(stockPhysique==null) return  BigDecimal.valueOf(0,4);
		return stockPhysique;
	}

	public void setStockPhysique(BigDecimal stock) {
		this.stockPhysique = stock;
	}

	public String getDepot() {
		return depot;
	}

	public void setDepot(String depot) {
		this.depot = depot;
	}

}
