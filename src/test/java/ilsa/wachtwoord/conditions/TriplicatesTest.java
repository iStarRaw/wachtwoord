package ilsa.wachtwoord.conditions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ilsa.wachtwoord.models.Wachtwoord;
import ilsa.wachtwoord.models.WachtwoordGenerator;

class TriplicatesTest {
	private WachtwoordGenerator wg;
	private Wachtwoord ww;
	private TriplicatesCondition tp;
	
	@BeforeEach
	public void initObjects() {
		wg = new WachtwoordGenerator();
		ww = new Wachtwoord();
		tp = new TriplicatesCondition();
		
	}

	@Test
	public void testContainsTriplicatesforThreeChars() {
		List<Character> list = new ArrayList<>(Arrays.asList('d','e','k','e','w','y','q','e'));
		char charToAdd = 'c';
		
		
		boolean resultTrue = tp.testCondition(list, charToAdd);
		
		assertTrue(resultTrue);	
		
	}
	
	
	@Test
	public void testContainsTriplicatesFalse() {
	List<Character> list = new ArrayList<>(Arrays.asList('d','e','k','e','w','y','q','r'));
	char charToAdd = 'c';
	
	boolean resultFalse = tp.testCondition(list, charToAdd);
	
	assertFalse(resultFalse);
	
	}
	
	
	@Test
	public void testContainsTriplicatesFalseOnlyDuplicates() {
	List<Character> list = new ArrayList<>(Arrays.asList('d','e','k','e','w','w','q','r'));
	char charToAdd = 'c';
	
	boolean resultFalse = tp.testCondition(list, charToAdd);
	
	assertFalse(resultFalse);
	
	}


}
