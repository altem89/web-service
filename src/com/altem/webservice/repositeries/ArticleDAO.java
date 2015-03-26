package com.altem.webservice.repositeries;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.altem.webservice.entities.Article;

@Stateless
public class ArticleDAO{ 
	
	@EJB
	private DAO dao; 
	
	public Article create(String id,String idWithoutX,String libelle,String type){
		Article article=new Article();
		article.setId(id);
		article.setCodeArticleWithoutX(idWithoutX);
		article.setLibelle(libelle);
		article.setType(type);
		return dao.create(article);
	}
	
	public List<Article> list(int min,int max){
		return dao.namedFind(Article.class, "article.list", min, max);
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> listArticleType(String typ){
		return (List<Article>) dao.getEntityManager().createNamedQuery("articleType.get").setParameter("type", typ).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> listArticleEnStock(){
		String query="select a from com.altem.webservice.entities.Stock s, Article a where s.codeStockArticle=a.id and s.stockPhysique > 1 and s.depot='001'";
		return (List<Article>)dao.getEntityManager().createQuery(query).getResultList();
	}
	
	public Article getArticle(String idWithoutX){
		return (Article) dao.getEntityManager().createNamedQuery("article.get").setParameter("codeArticle", idWithoutX).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> getAllVallibre1(BigDecimal valeur){
		return (List<Article>) dao.getEntityManager().createNamedQuery("vallibre1Spec.getAll").setParameter("val",valeur+"%").getResultList();
	}

	public void delete(String id) {
		Article article=getArticle(id);
		if(article==null){
			throw new IllegalArgumentException("article with id:"+id+" is not found");
		}
		dao.getEntityManager().remove(article);
	}
	
	public Article update(String id,String libelle,String type){
		Article article=getArticle(id);
		if(article==null){
			throw new IllegalArgumentException("article with id:"+id+" is not found");
		}
		
		article.setLibelle(libelle);
		article.setType(type);
		return dao.update(article);
	}
	
	public List<String> listFamilleniv1(){
		return dao.namedFind(String.class, "familleniv1.get", 0,100);
	}
	
	public List<String> listFamilleniv2(){
		return dao.namedFind(String.class, "familleniv2.get", 0,100);
	}
	
	public List<String> listFamilleniv3(){
		return dao.namedFind(String.class, "familleniv3.get", 0,100);
	}
	
	public List<String> listLibreart1(){
		return dao.namedFind(String.class, "libreart1.get", 0,100);
	}
	
	public List<String> listLibreart2(){
		return dao.namedFind(String.class, "libreart2.get", 0,100);
	}
	
	public List<String> listLibreart3(){
		return dao.namedFind(String.class, "libreart3.get", 0,100);
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> listArticleFamilleniv1(String famille){
		return (List<Article>) dao.getEntityManager().createNamedQuery("familleniv1.list").setParameter("fam", famille).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> listArticleFamilleniv2(String famille){
		return (List<Article>) dao.getEntityManager().createNamedQuery("familleniv2.list").setParameter("fam", famille).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> listArticleFamilleniv3(String famille){
		return (List<Article>) dao.getEntityManager().createNamedQuery("familleniv3.list").setParameter("fam", famille).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> listArticleLibreart1(String libreart){
		return (List<Article>) dao.getEntityManager().createNamedQuery("libreart1.list").setParameter("libr",libreart ).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> listArticleLibreart2(String libreart){
		return (List<Article>) dao.getEntityManager().createNamedQuery("libreart2.list").setParameter("libr",libreart ).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> listArticleLibreart3(String libreart){
		return (List<Article>) dao.getEntityManager().createNamedQuery("libreart3.list").setParameter("libr",libreart ).getResultList();
	}

	

}
