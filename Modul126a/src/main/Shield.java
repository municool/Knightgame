package main;

import java.util.Random;

/**
 * @author vmadmin
 * Ist ein Schild
 * Setzt und returniert die Defensiv und Nameswerte
 */
public class Shield {
	private int defense;
	private String name;
	Random rand = new Random();
	
	public Shield(String strname){
		name = strname;
		setDefense();
	}
	
	private void setDefense(){
		defense = rand.nextInt((20 - 10) + 1) + 10;
	}
	
	public int getDefense() {
		return defense;
	}

	public String getName() {
		return name;
	}

}
