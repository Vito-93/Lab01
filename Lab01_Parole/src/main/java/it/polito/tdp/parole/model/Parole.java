package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {

	List<String> lista;
		
	public Parole() {
		//lista = new ArrayList<String>();
		lista = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		lista.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(lista);
		return lista;
	}
	
	public void reset() {
		lista.clear();
	}

	public void removeParola(String s){
		lista.remove(s);
	}

}
