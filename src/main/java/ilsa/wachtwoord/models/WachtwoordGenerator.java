package ilsa.wachtwoord.models;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WachtwoordGenerator {
	private final String CANDIDATE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%~_^&*/(/)///-/+/=/[/]/{/}/|/`?><.,";
	private SecureRandom secGenerator = new SecureRandom();
	private List<Character> password;
	private Map<Character, Integer> charCount = new HashMap<Character, Integer>(); // voor bijhouden triplicates
	
	public String generatePassword(int length) {

		createPassword();

		char first = generateChar();
		addCharToPassword(first); // 1e character

		char second = generateChar();
		addCharToPassword(second); // 2e character

		for (int i = 2; i < length; i++) {
			char nextChar = generateThirdChar();
			addCharToPassword(nextChar);

			replaceIfNeeded();
		}
		
		//TODO check last 2 chars

		String str = password.stream().map(e -> e.toString()).collect(Collectors.joining());
		return str;

	}

	/**
	 * Creates a new list where the password can be generated into
	 */
	private void createPassword() {
		password = new ArrayList<>();
	}

	/**
	 * Generates one random char. Extended ASCII: 0 - 255
	 * 
	 * @return char
	 */
	public char generateChar() {
		char randomChar = CANDIDATE_CHARS.charAt(secGenerator.nextInt(CANDIDATE_CHARS.length()));
		return randomChar;
	}

	/**
	 * Adds a char to the list
	 */
	private void addCharToPassword(char c) {
		password.add(c);

	}

	/**
	 * Checks the existing sequence of the characters in the password with the
	 * conditions set by the RIVG. If these are not met the corresponding char will
	 * be replaced.
	 */
	private void replaceIfNeeded() {
		while (containsSequence()) {
			replaceLastChar();
		}

		while (containsTriplicates(password)) {
			replaceLastChar();
		}
	}

	/**
	 * 
	 * Checks whether the password contains the same char 3 times.
	 * 
	 * @return boolean
	 */
	public boolean containsTriplicates(List<Character> list) {
		for (Character c : list) {
			Integer count = charCount.get(c);
			charCount.put(c, (count == null) ? 1 : count + 1);
					
			if (charCount.containsValue(3)) {
				return true;
			}
		}
		return false;

	}

	public boolean containsSequence() {
		return false;
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	private void replaceLastChar() {
		password.remove(password.size() - 1);
		password.add(generateChar());

	}

	private char generateFourthTillEightChar() {
		return 0;
		// TODO No switch or ifs: better map or polymorphism

	}

	private boolean lastThreeAllSymbol() {
		return false;
		// TODO Auto-generated method stub

	}

	private boolean lastThreeAllDigit() {
		return false;
		// TODO Auto-generated method stub

	}

	private boolean lastThreeAllLetter() {
		return false;
		// TODO Auto-generated method stub

	}

	private char generateThirdChar() {
		// TODO No switch or ifs: better map or polymorphism
		char c;
		if (lastTwoAllLetter()) {
			return generateLetterChar();
		} else if (lastTwoAllDigit()) {
			return generateDigitChar();
		} else if (lastTwoAllSymbol()) {
			return generateSymbolChar();
		} else {
			return generateChar();
		}

	}

	private char generateSymbolChar() {
		return 0;
		// TODO Auto-generated method stub

	}

	private char generateDigitChar() {
		return 0;
		// TODO Auto-generated method stub

	}

	private char generateLetterChar() {
		return 0;
		// TODO Auto-generated method stub

	}

	private boolean lastTwoAllSymbol() {
		return false;
		// TODO Auto-generated method stub

	}

	private boolean lastTwoAllDigit() {
		return false;
		// TODO Auto-generated method stub

	}

	private boolean lastTwoAllLetter() {
		return false;
		// TODO Auto-generated method stub

	}

}
