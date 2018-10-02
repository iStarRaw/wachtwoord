package ilsa.wachtwoord.conditions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TriplicatesTest {
	private List<Character> list;
	private TriplicatesCondition tp;

	@BeforeEach
	public void initObjects() {
		tp = new TriplicatesCondition();

	}

	@Test
	public void testContainsTriplicatesTrue() {
		list = new ArrayList<>(Arrays.asList('d', 'e', 'k', 'e', 'w', 'y', 'q', 'e'));
		char charToAdd = 'e';

		boolean resultTrue = tp.testCondition(list, charToAdd);

		assertTrue(resultTrue);
	}

	@Test
	public void testContainsTriplicatesFalse() {
		list = new ArrayList<>(Arrays.asList('d', 'e', 'k', 't', 'w', 'y', 'q', 'e'));
		char charToAdd = 'e';

		boolean resultFalse = tp.testCondition(list, charToAdd);

		assertFalse(resultFalse);
	}

	@Test
	public void testContainsTriplicatesFalseOnlyDuplicates() {
		list = new ArrayList<>(Arrays.asList('d', 'e', 'k', 'e', 'w', 'w', 'q', 'r'));
		char charToAdd = 'e';

		boolean resultFalse = tp.testCondition(list, charToAdd);

		assertFalse(resultFalse);
	}

}
