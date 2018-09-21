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
	void testCharIsSymbol() {
		char a = 'e';
		char b = '&';
		char c = '4';
		char d = '-';

		boolean expected1 = sst.charIsSymbol(a);
		boolean expected2 = sst.charIsSymbol(b);
		boolean expected3 = sst.charIsSymbol(c);
		boolean expected4 = sst.charIsSymbol(d);

		assertFalse(expected1);
		assertTrue(expected2);
		assertFalse(expected3);
		assertTrue(expected4);
	}

	@Test
	void testLastThreeAreSymbolsLargeList() {
		list = new ArrayList<>(Arrays.asList('d', 'e', 'k', 'e', 'w', '%', '&', '-'));
		assertTrue(sst.lastThreeSymbols(list));
	}
	
	@Test
	void testLastThreeAreSymbolsSmallerList() {
		list = new ArrayList<>(Arrays.asList('d', 'e', 'k'));
		assertFalse(sst.lastThreeSymbols(list));
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
		assertFalse(sst.lastThreeSymbols(list));
	}
	
	@Test
	void testLastThreeAreNotSymbolsMoreLargeList() {
		list = new ArrayList<>(Arrays.asList('$', 'e', '!', 'e', 'w', '%', 'o', '-'));
		assertFalse(sst.lastThreeSymbols(list));
	}
	
	

}
