package it.polito.tdp.alien.model;

import java.util.Objects;

public class Word {

	private String humanWord;
	private String alienWord;
	
	public Word(String humanWord, String alienWord) {
		this.humanWord = humanWord;
		this.alienWord = alienWord;  }

	public String getHumanWord() {
		return humanWord; }

	public void setHumanWord(String humanWord) {
		this.humanWord = humanWord;  }

	public String getAlienWord() {
		return alienWord; }

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;  }

	@Override
	public int hashCode() {
		return Objects.hash(alienWord, humanWord);   }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(alienWord, other.alienWord) && Objects.equals(humanWord, other.humanWord); } 
	
	
}

