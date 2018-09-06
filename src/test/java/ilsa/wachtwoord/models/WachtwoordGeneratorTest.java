package ilsa.wachtwoord.models;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WachtwoordGeneratorTest {

	@Test
	void testGenerateCharForValidChar() {
		WachtwoordGenerator wg = new WachtwoordGenerator();
		String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%~_^&*/(/)///-/+/=/[/]/{/}/|/`?><.,";
		String noCandidateChar = " ";
		
		char result = wg.generateChar();
		
		assertTrue(candidateChars.contains(Character.toString(result)));
		assertFalse(noCandidateChar.contains(Character.toString(result)));
		
	}
	
	
}
