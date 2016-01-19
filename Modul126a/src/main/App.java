package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class App {

	public App() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Weapon sword = new Weapon(random(15, 10), "Sword");
		Weapon axe = new Weapon(random(15, 10), "Axe");
		Weapon hammer = new Weapon(random(15, 10), "Hammer");

		Shield playershield = new Shield("playershield");
		Shield enemyshield = new Shield("enemyshield");

		Knight player = new Knight();
		Knight enemy = new Knight();

		String weapon = "";
		boolean test;

		ArrayList<String> weapons = new ArrayList<String>();
		weapons.add("axe");
		weapons.add("sword");
		weapons.add("hammer");

		try {
			// set name
			System.out.println("What is your name sir: ");
			player.setName(br.readLine());

			// Choose weapon
			while (!weapons.contains(weapon)) {
				System.out.println("Choose a Weapon sir(Sword(" + sword.getAttack() + "), Axe(" + axe.getAttack() 
									+ "), Hammer(" + hammer.getAttack() + ")): ");
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

			player.setAttack(random(25, 15));
			player.setDefens(random(20, 10));
			player.setShield(playershield);

			// Set enemy stats
			enemy.setAttack(random(25, 15));
			enemy.setDefens(random(20, 10));
			enemy.setName("Günter");
			enemy.setWeapon(sword);
			enemy.setShield(enemyshield);

			// Show Player Equipment
			System.out.println("Your equipment sir: ");
			Showequipment(player);

			// Show Enemy Equipment
			System.out.println("Enemy equipment sir: ");
			Showequipment(enemy);

		} catch (IOException e) {
			System.out.println(e);
		}

		try {
			//Fight
			while (player.getHealth() > 0 && enemy.getHealth() > 0) {
				String input = "";
				do {
					System.out.println("Block or attack?(b/a): ");
					input = br.readLine();
				} while (!input.equals("a") && !input.equals("b"));

				if (input.equals("a")) {
					if (attack(player, enemy)) {
						break;
					}
					if (attack(enemy, player)) {
						break;
					}
				} else {
					if (block(player, enemy)) {
						break;
					}
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new App();
	}

	//Show equipment
	private void Showequipment(Knight knight) {
		System.out.println("Name: Sir " + knight.getName());
		System.out.println("Attack: " + knight.getAttack());
		System.out.println("Defense: " + knight.getDefens());
		System.out.println("Weapon: " + knight.getWeaponname() + "\n");
	}

	// Attack
	private boolean attack(Knight knight, Knight enemy) {
		System.out.println(knight.getName() + " attacks " + enemy.getName());
		knight.attackEnemy(enemy);
		System.out.println(enemy.getName() + " has now " + enemy.getHealth() + "HP. \n");
		if (enemy.getHealth() == 0) {
			System.out.println("\n" + enemy.getName() + " died.");
			return true;
		}
		return false;
	}

	// Block
	private boolean block(Knight knight, Knight enemy) {
		int defense = knight.getDefens();
		System.out.println(knight.getName() + " blocks the attack from " + enemy.getName());
		Shield shield = knight.getShield();
		knight.setDefens(defense + shield.getDefense());
		enemy.attackEnemy(knight);
		System.out.println(knight.getName() + " has now " + knight.getHealth() + "HP. \n");
		knight.setDefens(defense);
		if (enemy.getHealth() == 0) {
			System.out.println("\n" + enemy.getName() + " died.");
			return true;
		}
		return false;
	}
	
	private int random(int max, int min){
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

}