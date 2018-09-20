package ilsa.wachtwoord.conditions;

import java.util.List;

public class SameSortTogetherCondition implements Condition {
	private final String REGEX_LETTER = "";
	private final String REGEX_DIGIT = "";

	@Override
	public boolean testCondition(List<Character> list, char charToAdd) {
		return (lastTwoLetter(list) || lastTwoDigit(list) || lastTwoSymbol(list));

	}


	public boolean lastTwoLetter(List<Character> list) {
		int INDEX_LAST = list.size() - 1;
		int INDEX_BEFORE_LAST = list.size() - 2;

		return (Character.isLetter(INDEX_LAST) && Character.isLetter(INDEX_BEFORE_LAST));
	}


	public boolean lastTwoDigit(List<Character> list) {
		int INDEX_LAST = list.size() - 1;
		int INDEX_BEFORE_LAST = list.size() - 2;

		return (Character.isDigit(INDEX_LAST) && Character.isDigit(INDEX_BEFORE_LAST));
	}
	
	
	private boolean lastTwoSymbol(List<Character> list) {
		int INDEX_LAST = list.size() - 1;
		int INDEX_BEFORE_LAST = list.size() - 2;
	
		return  ((!Character.isDigit(INDEX_LAST) && !Character.isLetter(INDEX_LAST)) && (!Character.isDigit(INDEX_BEFORE_LAST) && !Character.isLetter(INDEX_BEFORE_LAST)));
	}
	

}
