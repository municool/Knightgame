package main;

/**
 * 
 * @author vmadmin
 * Ist eine Waffe
 * Setzt und returniert die Angriffswerte, Nameswerte und die Kritchance
 */
public class Weapon {
    private int attack;
    private int critchance = 10;
    private String name;

    /**
     * Constructor of Class Weapon
     * @param attack
     * @param name
     */
    public Weapon(int attack,String name){
        this.attack = attack;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

	public int getCritchance() {
		return critchance;
	} 
    
}
