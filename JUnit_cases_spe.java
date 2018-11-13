import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnit_cases_spe {

	private Tresor treasure = new Tresor(1,2);
	private Piege trap = new Piege(5,7);
	private Teleportation tp = new Teleportation(4,1);
	private Soin heal = new Soin(9,4);
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void activationTresor() {
		assertTrue(treasure.activation(1,2));
	}

	@Test
	void activationPiege() {
		assertTrue(trap.activation(5,7));
	}
	
	@Test
	void activationTeleportation() {
		assertTrue(tp.activation(4,1));
	}
	
	@Test
	void activationSoin() {
		assertTrue(heal.activation(9,4));
	}
	
	@Test
	void testGainDeVie() {
		assertEquals(heal.gainVie(250,9,4),280);
	}
	
	@Test
	void testPiege() {
		assertEquals(trap.degatsPiege(250, 5, 7),220);
	}
	
}
