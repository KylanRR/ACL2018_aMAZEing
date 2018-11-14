import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

class JUnit_movement {
	
	private Heros heros = new Heros(1,2);
	private Monstre monstre=new Monstre(5,7);
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void testdeplacementheros() {
		assertTrue(heros.checkupdate(1,2));	
	}

	@Test
	void testdeplacementmonstres() {
		assertTrue(monstre.checkupdate(5,7));
	}
	@Test
	void testdeplacementaleatoiremonstres() {
		assertTrue(monstre.checkrandom(10,2));
	}
	
	@Test
	void testattack() {
		assertEquals(heros.attack(100),70);
	}
}
