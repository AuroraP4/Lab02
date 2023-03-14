package it.polito.tdp.alien.model;

import java.util.*;

public class Dictionary {
	TreeMap<String, Word> dizionari ;
	
public Dictionary() {
		dizionari = new TreeMap<String, Word>();  }

public void inserireNelDizionario(String human, String alien) {
		
	if(!dizionari.containsKey(alien)) {
			Word parole = new Word(human, alien);
			dizionari.put(alien, parole); }  
}

public String traduzioneParola (String alien) {
	
	if(dizionari.containsKey(alien))  {
		return dizionari.get(alien).getHumanWord();  }
	else {
		return null; }
	

} }