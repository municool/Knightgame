package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class App {

	public App() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();

		Weapon sword = new Weapon(10, "Sword");
		Weapon axe = new Weapon(11, "Axe");
		Weapon hammer = new Weapon(12, "Hammer");
		Knight player = new Knight();
		Knight enemy = new Knight();
		String weapon = "";
		ArrayList<String> weapons = new ArrayList<String>();
		  weapons.add("axe");
		  weapons.add("sword");
		  weapons.add("hammer");

		try {
			//set name
			System.out.println("What is your name sir: ");
			player.setName(br.readLine());
			
			//Choose weapon
			while(!weapons.contains(weapon)){
			     System.out.println("Choose a Weapon sir(Sword, Axe, Hammer): ");
			     weapon = br.readLine().toLowerCase();
			  }
			
			switch (weapon) {
			case "sword":
				player.setWeapon(sword);
				break;
			case "axe":
				player.setWeapon(axe);
				break;
			case "hammer":
				player.setWeapon(hammer);
				break;
			}
			
			player.setAttack(rand.nextInt((25 - 15) + 1) + 15);
			player.setDefens(rand.nextInt((20 - 10) + 1) + 10);
			
			//Set enemy stats
			enemy.setAttack(rand.nextInt((25 - 15) + 1) + 15);
			enemy.setDefens(rand.nextInt((20 - 10) + 1) + 10);
			enemy.setName("Günter");
			enemy.setWeapon(sword);
			
			//Show Player Equipment
			System.out.println("Your equipment sir: ");
			Showequipment(player);
			
			//Show Enemy Equipment
			System.out.println("Enemy equipment sir: ");
			Showequipment(enemy);

		} catch (IOException e) {
			System.out.println(e);
		}

		

		while (player.getHealth() > 0 && enemy.getHealth() > 0) {
			System.out.println(player.getName() + " attacks " + enemy.getName());
			player.attackEnemy(enemy);
			System.out.println(enemy.getName() + " has now " + enemy.getHealth() + "HP. \n");

			if (enemy.getHealth() == 0) {
				System.out.println("\n" + enemy.getName() + " died.");
				break;
			}

			System.out.println(enemy.getName() + " attacks " + player.getName());
			enemy.attackEnemy(player);
			System.out.println(player.getName() + " has now " + player.getHealth() + "HP. \n");

			if (player.getHealth() == 0) {
				System.out.println(player.getName() + " died.");
				break;
			}
		}
	}

	public static void main(String[] args) {
		new App();
	}
	
	private void Showequipment(Knight knight){
		System.out.println("Name: Sir " + knight.getName());
		System.out.println("Attack: " + knight.getAttack());
		System.out.println("Defense: " + knight.getDefens());
		System.out.println("Weapon: " + knight.getWeaponname()+ "\n");
	}
}