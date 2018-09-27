package ilsa.wachtwoord.models;

import java.security.SecureRandom;

import ilsa.wachtwoord.conditions.SameSortTogetherCondition;
import ilsa.wachtwoord.conditions.SequenceCondition;
import ilsa.wachtwoord.conditions.TriplicatesCondition;

public class WachtwoordGenerator {
	private final String CANDIDATE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%~_^&*/(/)///-/+/=/[/]/{/}/|/`?><.,";
	private final String CANDIDATE_DIGITS = "0123456789";
	private final String CANDIDATE_SYMBOLS = "!@#$%~_^&*/(/)///-/+/=/[/]/{/}/|/`?><.,";
	private final String CANDIDATE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final String CANDIDATE_SYMBOLS_AND_DIGITS = "!@#$%~_^&*/(/)///-/+/=/[/]/{/}/|/`?><.,0123456789";
	private final String CANDIDATE_DIGITS_AND_LETTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final String CANDIDATE_LETTERS_AND_SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz\"!@#$%~_^&*/(/)///-/+/=/[/]/{/}/|/`?><.,";

	private SecureRandom secGenerator = new SecureRandom();

	private Wachtwoord ww;

	private SequenceCondition sq;
	private TriplicatesCondition tp;
	private SameSortTogetherCondition sst;

	public WachtwoordGenerator() {
		sq = new SequenceCondition();
		tp = new TriplicatesCondition();
		sst = new SameSortTogetherCondition();
	}

	public void generatePassword(int length) {

		ww = new Wachtwoord(length);

		for (int i = 0; i < length; i++) {

			char charToAdd = generateChar();
			ww.addCharToPassword(charToAdd);
			String charSort = sst.findSortFirstTwo(ww.getPassword());

			replaceTwoTogetherIfNeeded(charToAdd, charSort);

			replaceFourTogetherIfNeeded(charSort);

			replaceSequenceIfNeeded(charToAdd);

			replaceTriplicatesIfNeeded(charToAdd);

		}

		checkLastTwoCharsAndReplaceIfNeeded();

		System.out.println(ww.toString());

	}

	/**
	 * Checks whether the first two chars of a pair of three are of the same sort.
	 * If the one before the first (the last of the pair of three before) is of
	 * another sort, it replaces the last char. If the one before is of the same
	 * sort it leaves the last char like it is.
	 * 
	 * @param charToAdd
	 * @param charSort
	 */
	private void replaceTwoTogetherIfNeeded(char charToAdd, String charSort) {
		if (sst.testCondition(ww.getPassword(), charToAdd) && !sst.firstTwoSameAndBeforeAsWell(ww.getPassword())) {
			replaceLastCharWithSameSort(charSort);
		}
	}

	/**
	 * Checks whether there are four chars of the same sort next to eachother. If
	 * so, it replaces the last char with a char of another sort.
	 * 
	 * @param charSort
	 */
	private void replaceFourTogetherIfNeeded(String charSort) {
		if (sst.lastFourSameSort(ww.getPassword())) {
			replaceLastCharWithOtherSort(charSort);
		}
	}

	/**
	 * Replaces the last char of a sequence (k,l,m or 1,2,3 c,b,a etc) with another
	 * random char.
	 * 
	 * @param charToAdd
	 */
	private void replaceSequenceIfNeeded(char charToAdd) {
		while (sq.testCondition(ww.getPassword(), charToAdd)) {
			replaceLastChar();
		}
	}

	/**
	 * Checks if the last two chars of the list are of the same sort. If so, the
	 * last char will be replaced.
	 */
	private void checkLastTwoCharsAndReplaceIfNeeded() {
		if (sst.areTwoSameSort(ww.getPassword(), ww.getMaxChar() - 1, ww.getMaxChar() - 2)) {
			String charLast = sst.findSortLastTwo(ww.getPassword());
			replaceLastCharWithOtherSort(charLast);
		}
	}

	/**
	 * Replaces last char with another random char of another type
	 * 
	 * @param sortChar
	 */
	private void replaceLastCharWithOtherSort(String sortChar) {
		switch (sortChar) {
		case "Digit":
			replaceLastCharWithLetterOrSymbol();
			break;
		case "Symbol":
			replaceLastCharWithDigitOrLetter();
			break;
		case "Letter":
			replaceLastCharWithSymbolOrDigit();
			break;
		}
	}

	private void replaceLastCharWithSymbolOrDigit() {
		ww.removeLastChar();
		char charToAdd = generateSymbolOrDigit();
		ww.addCharToPassword(charToAdd);
	}

	private void replaceLastCharWithDigitOrLetter() {
		ww.removeLastChar();
		char charToAdd = generateDigitOrLetter();
		ww.addCharToPassword(charToAdd);
	}

	private void replaceLastCharWithLetterOrSymbol() {
		ww.removeLastChar();
		char charToAdd = generateLetterOrSymbol();
		ww.addCharToPassword(charToAdd);
	}

	/**
	 * Replaces last char with a char of the same sort.
	 * 
	 * @param sortChar
	 */
	private void replaceLastCharWithSameSort(String sortChar) {
		switch (sortChar) {
		case "Digit":
			replaceLastCharWithDigit();
			break;
		case "Symbol":
			replaceLastCharWithSymbol();
			break;
		case "Letter":
			replaceLastCharWithLetter();
			break;
		}
	}

	/**
	 * Checks the list for triplicates and replaces the last char with another
	 * random char if needed.
	 * 
	 * @param charToAdd
	 */
	private void replaceTriplicatesIfNeeded(char charToAdd) {
		while (tp.testCondition(ww.getPassword(), charToAdd)) {
			replaceLastChar();
		}
	}

	/**
	 * Replaces last char with random char of type letter.
	 */
	private void replaceLastCharWithLetter() {
		ww.removeLastChar();
		char charToAdd = generateLetter();
		ww.addCharToPassword(charToAdd);
	}

	/**
	 * Replaces last char with random char of type symbol.
	 */
	private void replaceLastCharWithSymbol() {
		ww.removeLastChar();
		char charToAdd = generateSymbol();
		ww.addCharToPassword(charToAdd);
	}

	/**
	 * Replaces last char with a random char of type digit.
	 */
	private void replaceLastCharWithDigit() {
		ww.removeLastChar();
		char charToAdd = generateDigit();
		ww.addCharToPassword(charToAdd);
	}

	/**
	 * Replaces last char with another random char.
	 */
	private void replaceLastChar() {
		ww.removeLastChar();
		char charToAdd = generateChar();
		ww.addCharToPassword(charToAdd);
	}

	/**
	 * Generates one random char out of the above char string.
	 * 
	 * @return char
	 */
	public char generateChar() {
		int index = secGenerator.nextInt(CANDIDATE_CHARS.length());

		while (index < 0 || index > CANDIDATE_CHARS.length()) {
			index = secGenerator.nextInt(CANDIDATE_CHARS.length());
		}
		char randomChar = CANDIDATE_CHARS.charAt(index);
		return randomChar;
	}

	/**
	 * Generates one random digit out of the above digit string.
	 * 
	 * @return char
	 */
	public char generateDigit() {
		int index = secGenerator.nextInt(CANDIDATE_DIGITS.length());

		while (index < 0 || index > CANDIDATE_DIGITS.length()) {
			index = secGenerator.nextInt(CANDIDATE_DIGITS.length());
		}
		char randomDigit = CANDIDATE_DIGITS.charAt(index);
		return randomDigit;
	}

	/**
	 * Generates one random letter out of the above letter string.
	 * 
	 * @return char
	 */
	public char generateLetter() {
		int index = secGenerator.nextInt(CANDIDATE_LETTERS.length());

		while (index < 0 || index > CANDIDATE_LETTERS.length()) {
			index = secGenerator.nextInt(CANDIDATE_LETTERS.length());
		}
		char randomLetter = CANDIDATE_LETTERS.charAt(secGenerator.nextInt(CANDIDATE_LETTERS.length()));
		return randomLetter;
	}

	/**
	 * Generates one random symbol out of the above symbol string.
	 * 
	 * @return char
	 */
	public char generateSymbol() {
		int index = secGenerator.nextInt(CANDIDATE_SYMBOLS.length());

		while (index < 0 || index > CANDIDATE_SYMBOLS.length()) {
			index = secGenerator.nextInt(CANDIDATE_SYMBOLS.length());
		}
		char randomSymbol = CANDIDATE_SYMBOLS.charAt(secGenerator.nextInt(CANDIDATE_SYMBOLS.length()));
		return randomSymbol;
	}

	/**
	 * Generates one random symbol or digit out of the above symbol&digit string.
	 * 
	 * @return char
	 */
	private char generateSymbolOrDigit() {
		int index = secGenerator.nextInt(CANDIDATE_SYMBOLS_AND_DIGITS.length());

		while (index < 0 || index > CANDIDATE_SYMBOLS_AND_DIGITS.length()) {
			index = secGenerator.nextInt(CANDIDATE_SYMBOLS_AND_DIGITS.length());
		}
		char randomSymbolOrDigit = CANDIDATE_SYMBOLS_AND_DIGITS
				.charAt(secGenerator.nextInt(CANDIDATE_SYMBOLS_AND_DIGITS.length()));
		return randomSymbolOrDigit;
	}

	/**
	 * Generates one random digit or letter out of the above digit&letter string.
	 * 
	 * @return char
	 */
	private char generateDigitOrLetter() {
		int index = secGenerator.nextInt(CANDIDATE_DIGITS_AND_LETTERS.length());

		while (index < 0 || index > CANDIDATE_DIGITS_AND_LETTERS.length()) {
			index = secGenerator.nextInt(CANDIDATE_DIGITS_AND_LETTERS.length());
		}
		char randomDigit = CANDIDATE_DIGITS_AND_LETTERS.charAt(index);
		return randomDigit;
	}

	/**
	 * Generates one random letter of symbol out of the above letter&symbol string.
	 * 
	 * @return char
	 */
	private char generateLetterOrSymbol() {
		int index = secGenerator.nextInt(CANDIDATE_LETTERS_AND_SYMBOLS.length());

		while (index < 0 || index > CANDIDATE_LETTERS_AND_SYMBOLS.length()) {
			index = secGenerator.nextInt(CANDIDATE_LETTERS_AND_SYMBOLS.length());
		}
		char randomSymbol = CANDIDATE_LETTERS_AND_SYMBOLS
				.charAt(secGenerator.nextInt(CANDIDATE_LETTERS_AND_SYMBOLS.length()));
		return randomSymbol;
	}
}
