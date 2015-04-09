package com.altem.webservice.entities;

import java.io.Serializable;

public class ChoixCodePK implements Serializable {

private static final long serialVersionUID = 1651617515L;
private String type;
private String code;

public ChoixCodePK(){
	
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}

public boolean equals(Object obj){
	boolean resultat=false;
	if(obj==this){
		resultat=true;
	}
	else{
		if(!(obj instanceof ChoixCodePK)){
			resultat=false;
		}
		else{
			ChoixCodePK autre=(ChoixCodePK) obj;
			if(!type.equals(autre.type)){
				resultat=false;
			}
			else{
				if(!code.equals(autre.code)){
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
	ch.append(type).append(code);
	return (ch.toString()).hashCode();
}
}
