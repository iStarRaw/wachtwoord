package ilsa.wachtwoord.models;

import java.security.SecureRandom;
import java.util.List;

import ilsa.wachtwoord.conditions.SameSortTogetherCondition;
import ilsa.wachtwoord.conditions.SequenceCondition;
import ilsa.wachtwoord.conditions.TriplicatesCondition;

public class WachtwoordGenerator {
	private final String CANDIDATE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%~_^&*/(/)///-/+/=/[/]/{/}/|/`?><.,";
	private SecureRandom secGenerator = new SecureRandom();

	private Wachtwoord ww;

	private SequenceCondition sq;
	private TriplicatesCondition tp;
	private SameSortTogetherCondition sst;

	public void generatePassword() {

		ww = new Wachtwoord(8);
		sq = new SequenceCondition();
		tp = new TriplicatesCondition();
		sst = new SameSortTogetherCondition();

		for (int i = 0; i < ww.getMaxChar(); i++) {

			//add char
			char charToAdd = generateChar();
			ww.addCharToPassword(charToAdd);
			System.out.println(ww.toString());
		
			//check for triplicates
			while (tp.testCondition(ww.getPassword(), charToAdd)) {
				replaceLastChar();
			}
			
			//check for sequences: ABC, 321
			while (sq.testCondition(ww.getPassword(), charToAdd)) {
				replaceLastChar();
			}
			
			//check for same sorts

		}

		// TODO check last 2 chars

		System.out.println(ww.toString());

	}

	
	private void replaceLastChar() {
		ww.removeLastChar();
		char charToAdd = generateChar();
		ww.addCharToPassword(charToAdd);
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
