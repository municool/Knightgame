package test;

import static org.junit.Assert.*;
import main.Knight;
import main.Weapon;

import org.junit.Test;



public class KnightTest {

	@Test
	public void testCalculateAttack() {
	     // Testdaten
     
		Weapon testWeapon = new Weapon(15, "Axe");
        Knight testKnight = createCompleteKnight(testWeapon);
        Knight testEnemy = createCompleteEnamy(testWeapon);
        
        int result = testKnight.calculateAttack(testEnemy);
        assertEquals(result, 20);
        
        assertNotEquals(result, 200);
        
        assertNotEquals(testKnight.getDefens(), 300);
	}
	

	@Test
	public void testAttackEnemy() {
		Weapon testWeapon = new Weapon(15, "Axe");
        Knight testKnight = createCompleteKnight(testWeapon);
        Knight testEnemy = createCompleteEnamy(testWeapon);
        
        testKnight.attackEnemy(testEnemy);
        assertTrue(testEnemy.getHealth() <= 100);

        assertFalse(testEnemy.getHealth() > 100);
        
        assertNotNull(testEnemy.getAttack());
	}

	private Knight createCompleteEnamy(Weapon testWeapon) {
		Knight testEnemy = new Knight();
        testEnemy.setHealth(100);
        testEnemy.setAttack(25);
        testEnemy.setDefens(15);
        testEnemy.setWeapon(testWeapon);
        testEnemy.setName("Günter");
		return testEnemy;
	}

	private Knight createCompleteKnight(Weapon testWeapon) {
		Knight testKnight = new Knight();
        testKnight.setHealth(100);
        testKnight.setAttack(20);
        testKnight.setDefens(10);
        testKnight.setWeapon(testWeapon);
        testKnight.setName("Theodor");
		return testKnight;
	}
}
