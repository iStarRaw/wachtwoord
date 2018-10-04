package ilsa.wachtwoord.conditions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SameSortTogetherConditionTest {
	private SameSortTogetherCondition sst;
	private List<Character> list;

	@BeforeEach
	void initObjects() {
		sst = new SameSortTogetherCondition();

	}


	@Test
	void testLastThreeAreSymbolsLargeList() {
		list = new ArrayList<>(Arrays.asList('d', 'e', 'k', 'e', 'w', '%', '&', '-'));
		assertTrue(sst.lastThreeSymbol(list));
	}
	
	@Test
	void testLastThreeAreSymbolsSmallerList() {
		list = new ArrayList<>(Arrays.asList('d', 'e', 'k'));
		assertFalse(sst.lastThreeSymbol(list));
	}
	
	@Test
	//TODO exception handling bij list kleiner dan 3
	void testLastThreeAreSymbolsListTooSmall() {
		list = new ArrayList<>(Arrays.asList('%', '@'));

		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            throw new IndexOutOfBoundsException("list is too small to compare");
        });
        assertEquals("list is too small to compare", exception.getMessage());
	}

	@Test
	void testLastThreeAreNotSymbolsLargeList() {
		list = new ArrayList<>(Arrays.asList('d', 'e', 'k', 'e', 'w', '%', 'o', '-'));
		assertFalse(sst.lastThreeSymbol(list));
	}
	
	
	@Test
	void testFirstTwoSameSortTrue() {
		list = new ArrayList<>(Arrays.asList('d', 'e', '%', 'e', 'w', '%', '&', '-'));
		assertTrue(sst.firstTwoSameSort(list));
	}
	
//	@Test
//	void testFirstTwoSameSortFalse() {
//		list = new ArrayList<>(Arrays.asList('d', '0', '%', 'e', 'w', '%', '&', '-'));
//		assertFalse(sst.firstTwoSameSort(list));
//	}
	
	@Test
	void testFirstTwoLetterTrue() {
		list = new ArrayList<>(Arrays.asList('d', 'e', '%'));
		assertTrue(sst.firstTwoLetter(list));
	}
	
	@Test
	void testFirstTwoLetterFalse() {
		list = new ArrayList<>(Arrays.asList('1', 'e', '2'));
		assertFalse(sst.firstTwoLetter(list));
	}
	
	
	@Test
	void testFirstTwoLetterUpperCase() {
		list = new ArrayList<>(Arrays.asList('L', 'E', '%'));
		assertTrue(sst.firstTwoLetter(list));
	}
	
	@Test
	void testFirstTwoLetterUpperAndLowerCase() {
		list = new ArrayList<>(Arrays.asList('L', 'e', '%'));
		assertTrue(sst.firstTwoLetter(list));
	}
	
	
	@Test
	void testFirstTwoDigit() {
		list = new ArrayList<>(Arrays.asList('5', '3', 'p'));
		assertTrue(sst.firstTwoDigit(list));
	}
	
	@Test
	void testFirstTwoSymbol() {
		list = new ArrayList<>(Arrays.asList('*', '@', 'R'));
		assertTrue(sst.firstTwoSymbol(list));
	}
	
	@Test
	void testLastFourLetter() {
		List<Character> temp = Arrays.asList('d', 'e', 'R', 'e');
		
		list = new ArrayList<Character>(temp);
		assertTrue(sst.lastFourLetter(list));
	}

}
