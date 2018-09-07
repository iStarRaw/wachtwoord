package ilsa.wachtwoord.models;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class WachtwoordGenerator {
	private final String CANDIDATE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%~_^&*/(/)///-/+/=/[/]/{/}/|/`?><.,";
	private SecureRandom secGenerator = new SecureRandom();	
	private List<Character> password;

	public String generatePassword() {
		
		createPassword();
		
		addCharToPassword(); // 1e character
		
		addCharToPassword(); // 2e character				


		generateThirdChar();
		addCharToPassword(); // 3e character

		while (containsSequence()) {
			replaceLastChar();
		}

		while (containsTriplicates()) {
			replaceLastChar();
		}

		generateFourthTillEightChar();
		addCharToPassword(); // 4e character
		
		while (containsSequence()) {
			replaceLastChar();
		}

		while (containsTriplicates()) {
			replaceLastChar();
		}
		
		generateFourthTillEightChar();
		addCharToPassword(); // 5e character
		
		while (containsSequence()) {
			replaceLastChar();
		}

		while (containsTriplicates()) {
			replaceLastChar();
		}
		
		generateFourthTillEightChar();
		addCharToPassword(); // 6e character
		
		while (containsSequence()) {
			replaceLastChar();
		}

		while (containsTriplicates()) {
			replaceLastChar();
		}
		
		generateFourthTillEightChar();
		addCharToPassword(); // 7e character
		
		while (containsSequence()) {
			replaceLastChar();
		}

		while (containsTriplicates()) {
			replaceLastChar();
		}
		
		generateFourthTillEightChar();
		addCharToPassword(); // 8e character
		
		while (containsSequence()) {
			replaceLastChar();
		}

		while (containsTriplicates()) {
			replaceLastChar();
		}
		
//		String str = password.stream().map(e -> e.toString()).collect(Collectors.joining());
//		System.out.println(str);
//		return str;
		return null;

	}

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
	private void addCharToPassword() {
		password.add(generateChar());
		
	}

	private void generateFourthTillEightChar() {
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

	private void replaceLastChar() {
		// TODO Auto-generated method stub

	}

	private boolean containsTriplicates() {
		return false;
		// TODO Auto-generated method stub

	}

	private boolean containsSequence() {
		return false;
		// TODO Auto-generated method stub

	}

	private void generateThirdChar() {
		// TODO No switch or ifs: better map or polymorphism
		if (lastTwoAllLetter()) {
			generateLetterChar();
		} else if (lastTwoAllDigit()) {
			generateDigitChar();
		} else if (lastTwoAllSymbol()) {
			generateSymbolChar();
		} else {
			generateChar();
		}

	}

	private void generateSymbolChar() {
		// TODO Auto-generated method stub

	}

	private void generateDigitChar() {
		// TODO Auto-generated method stub

	}

	private void generateLetterChar() {
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
