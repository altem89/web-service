package com.altem.webservice.entities;

import java.io.Serializable;

public class CommandePK implements Serializable {

	private static final long serialVersionUID = 989494551L;
	
	private int numero;
	private int numeroOrdre;
	
	public CommandePK(){
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumeroOrdre() {
		return numeroOrdre;
	}

	public void setNumeroOrdre(int numeroOrdre) {
		this.numeroOrdre = numeroOrdre;
	}
	
	public boolean equals(Object obj){
		boolean resultat=false;
		if(obj==this){
			resultat=true;
		}
		else{
			if(!(obj instanceof CommandePK)){
				resultat=false;
			}else{
				CommandePK autre=(CommandePK) obj;
				if(numero!=autre.numero){
					resultat=false;
				}
				else{
					if(numeroOrdre!=autre.numeroOrdre){
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
		ch.append(numero).append(numeroOrdre);
		return (ch.toString()).hashCode();
	}
}