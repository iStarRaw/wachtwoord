package ilsa.wachtwoord.models;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ilsa.wachtwoord.conditions.TriplicatesCondition;

public class WachtwoordGeneratorTest {
	private WachtwoordGenerator wg;
	
	@BeforeEach
	public void initObjects() {
		wg = new WachtwoordGenerator();
		
	}


	@Test
	public void testGenerateCharForValidChar() {
		String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%~_^&*/(/)///-/+/=/[/]/{/}/|/`?><.,";
		String noCandidateChar = " ";
		
		char result = wg.generateChar(candidateChars);
		
		assertTrue(candidateChars.contains(Character.toString(result)));
		assertFalse(noCandidateChar.contains(Character.toString(result)));
		
	}
	
	
	
	@Test
	public void testReplaceLastCharWithRandom() {
		
	}
	
	
	
}
