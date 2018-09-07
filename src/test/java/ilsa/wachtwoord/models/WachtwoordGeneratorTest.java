package ilsa.wachtwoord.models;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		
		char result = wg.generateChar();
		
		assertTrue(candidateChars.contains(Character.toString(result)));
		assertFalse(noCandidateChar.contains(Character.toString(result)));
		
	}
	
	@Test
	public void testContainsTriplicatesforThreeChars() {
		List<Character> list = new ArrayList<>(Arrays.asList('c','R','$','6','2','4','c','c'));
		
		boolean resultTrue = wg.containsTriplicates(list);
		
		assertTrue(resultTrue);	
		
	}
	
	
	@Test
	public void testContainsTriplicatesFalse() {
	List<Character> list = new ArrayList<>(Arrays.asList('c','R','$','6','2','4','-','f'));
	
	boolean resultFalse = wg.containsTriplicates(list);
	
	assertFalse(resultFalse);
	
	}
	
	
	@Test
	public void testContainsTriplicatesFalseOnlyDuplicates() {
	List<Character> list = new ArrayList<>(Arrays.asList('c','R','$','6','2','4','-','c'));
	
	boolean resultFalse = wg.containsTriplicates(list);
	
	assertFalse(resultFalse);
	
	}
	
	
	
	
}
