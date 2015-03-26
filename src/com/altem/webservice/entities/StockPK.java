package com.altem.webservice.entities;

import java.io.Serializable;

public class StockPK implements Serializable{

	private static final long serialVersionUID = 4696151651L;
	private String codeStockArticle;
	private String depot;
	
	public StockPK(){
		
	}
	
	public String getCodeStockArticle() {
		return codeStockArticle;
	}
	public void setCodeStockArticle(String codeStockArticle) {
		this.codeStockArticle = codeStockArticle;
	}
	public String getDepot() {
		return depot;
	}
	public void setDepot(String depot) {
		this.depot = depot;
	}
	
	public boolean equals(Object obj){
		boolean resultat=false;
		if(obj==this){
			resultat=true;
		}
		else{
			if(!(obj instanceof StockPK)){
				resultat=false;
			}else{
				StockPK autre=(StockPK) obj;
				if(!codeStockArticle.equals(autre.codeStockArticle)){
					resultat=false;
				}
				else{
					if(!depot.equals(autre.depot)){
						resultat=false;
					}
					else{
						resultat=true;
					}
				}
			}
		}
		return resultat;
	}
    
	public int hashCode(){
		StringBuilder ch=new StringBuilder();
		ch.append(depot).append(codeStockArticle);
		return (ch.toString()).hashCode();
	}
	
}
