package ilsa.wachtwoord.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WachtwoordTest {
	private Wachtwoord ww;
	private List<Character> password;
	
	@BeforeEach
	public void initObjects() {
		ww = new Wachtwoord(8);
		password = ww.getPassword();
	}

	@Test
	void testRemoveLastChar() {
		
		password.add('e');
		password.add('k');
		password.add('w');
		
		assertTrue(password.size() > 0);
		
		ww.removeLastChar();
		
		
		
	}

}
