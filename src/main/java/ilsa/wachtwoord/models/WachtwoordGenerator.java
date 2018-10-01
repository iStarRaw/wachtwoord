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

			char charToAdd = generateChar(CANDIDATE_CHARS);
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
	 * so, it replaces the last char with a char of another sort as long as there are four chars of the same sort.
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
	 * random char as long as there is a sequence.
	 * 
	 * @param charToAdd
	 */
	private void replaceSequenceIfNeeded(char charToAdd) {
		while (sq.testCondition(ww.getPassword(), charToAdd)) {
			replaceLastChar(CANDIDATE_CHARS);
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
			replaceLastChar(CANDIDATE_LETTERS_AND_SYMBOLS);
			break;
		case "Symbol":
			replaceLastChar(CANDIDATE_DIGITS_AND_LETTERS);
			break;
		case "Letter":
			replaceLastChar(CANDIDATE_SYMBOLS_AND_DIGITS);
			break;
		}
	}
	
	
	/**
	 * Replaces last char with a char of the same sort.
	 * 
	 * @param sortChar
	 */
	private void replaceLastCharWithSameSort(String sortChar) {
		switch (sortChar) {
		case "Digit":
			replaceLastChar(CANDIDATE_DIGITS);
			break;
		case "Symbol":
			replaceLastChar(CANDIDATE_SYMBOLS);
			break;
		case "Letter":
			replaceLastChar(CANDIDATE_LETTERS);
			break;
		}
	}
	

	/**
	 * Replaces the last char in the list with a char out of the given String.
	 * 
	 * @param candidateChars
	 */
	private void replaceLastChar(String candidateChars) {
		ww.removeLastChar();
		char charToAdd = generateChar(candidateChars);
		ww.addCharToPassword(charToAdd);
	}
	
	
	/**
	 * Checks the list for triplicates and replaces the last char with another
	 * random char if needed.
	 * 
	 * @param charToAdd
	 */
	private void replaceTriplicatesIfNeeded(char charToAdd) {
		while (tp.testCondition(ww.getPassword(), charToAdd)) {
			replaceLastChar(CANDIDATE_CHARS);
		}
	}
	
	
	

	

	/**
	 * Generates a random char out of the given String.
	 * 
	 * @param candidateChars
	 * @return char
	 */
	public char generateChar(String candidateChars) {
		int index = secGenerator.nextInt(candidateChars.length());

		while (index < 0 || index > candidateChars.length()) {
			index = secGenerator.nextInt(candidateChars.length());
		}
		char randomChar = candidateChars.charAt(index);
		return randomChar;
	}

	
}
