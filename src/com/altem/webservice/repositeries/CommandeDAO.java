package com.altem.webservice.repositeries;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.altem.webservice.entities.Commande;
import com.altem.webservice.entities.CommandePK;

@Stateless
public class CommandeDAO {
	
	@EJB
	private DAO dao;
	
	public List<Commande> list(int min,int max){
		return dao.namedFind(Commande.class, "commande.list", min, max);
	}
	
	@SuppressWarnings("unchecked")
	public List<Commande> listCommandeClient(String client){
		return (List<Commande>)dao.getEntityManager().createNamedQuery("commandeClient.list")
				.setParameter("name",client)
				.getResultList();
	}
	
	public Commande find(int num,int numOrdre){
		CommandePK comPK=new CommandePK();
		comPK.setNumero(num);
		comPK.setNumeroOrdre(numOrdre);
		return dao.find(Commande.class, comPK);
	}
	
	public Long getcountFacture(String clientCode,int numero){
		return (Long) dao.getEntityManager().createNamedQuery("factureNum.findCount").setParameter("client", clientCode)
				.setParameter("num", numero).getSingleResult();
				       
	}

}
