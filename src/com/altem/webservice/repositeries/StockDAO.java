package com.altem.webservice.repositeries;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.RollbackException;

import com.altem.webservice.entities.Stock;
import com.altem.webservice.entities.StockPK;

@Stateless
public class StockDAO extends DAO {
	
	@EJB
	private DAO dao;
	
	public Stock create(String codeArticle,String depot,BigDecimal stockP){
		Stock stock=new Stock();
		stock.setCodeStockArticle(codeArticle);
		stock.setDepot(depot);
		stock.setStockPhysique(stockP);
		return dao.create(stock);
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> list(){
		return (List<Stock>)dao.getEntityManager().createNamedQuery("stock.list").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> listProductDepot(String depot){
		return (List<Stock>) dao.getEntityManager().createNamedQuery("stockProductsDepot.list")
				.setParameter("dept",depot)
				.getResultList();
	}
	
	public Stock find(String depot,String codeStockArticle) {
		StockPK stockPK=new StockPK();
		stockPK.setCodeStockArticle(codeStockArticle);
		stockPK.setDepot(depot);
	    return dao.find(Stock.class, stockPK);
    }

	public void delete(String id) {
	    dao.delete(Stock.class, id);
	}
	
	public Stock update(String id,BigDecimal stockP){
		try{
		Stock stock=getStock(id);
		stock.setStockPhysique(stockP);
		return dao.update(stock);
		}
		catch(RollbackException e){
			throw new IllegalArgumentException("stock with id:"+id+" is not found");
		}
		
	}

	public Stock getStock(String code) {
		
		String query="select s from com.altem.webservice.entities.Article a, Stock s where a.id=s.codeStockArticle and s.depot='001' and a.codeArticleWithoutX=:code";
		return (Stock)dao.getEntityManager().createQuery(query).setParameter("code", code).getSingleResult();
		
	}

}
