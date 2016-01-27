package main;

/**
 * @author vmadmin
 * Ist ein Ritter
 * Berechnet die Angriffe des Ritters
 */
public class Knight {
	private int health = 100;
	private int attack;
	private int defense;
	private String name;
	private Weapon weapon;
	private Shield shield;

	public Shield getShield() {
		return shield;
	}
	
	public int getShieldvalue(){
		return shield.getDefense();
	}

	public void setShield(Shield shield) {
		this.shield = shield;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefens() {
		return defense;
	}

	public String getName() {
		return name;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public String getWeaponname() {
		String name = weapon.getName();
		return name;
	}
	
	public int getHealth() {
		return health;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setDefens(int defens) {
		this.defense = defens;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int calculateAttack(Knight enemy) {
		int damage = this.attack + this.weapon.getAttack() - enemy.getDefens();
		damage = calculateCrit(damage);

		return damage;
	}

	private int calculateCrit(int damage) {
		int crit = (int) (Math.random() * this.weapon.getCritchance());
		if (crit == 5) {
			damage = (int) (damage + (damage / 2));
			System.out.println("Oh my lord a critical hit!");
		}
		return damage;
	}

	public void attackEnemy(Knight enemy) {

		enemy.setHealth(enemy.getHealth() - calculateAttack(enemy));

		if (enemy.getHealth() < 0) {
			enemy.setHealth(0);
		}
	}
}
