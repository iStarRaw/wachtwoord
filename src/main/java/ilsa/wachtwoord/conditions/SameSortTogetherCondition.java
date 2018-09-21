package ilsa.wachtwoord.conditions;

import java.util.List;

public class SameSortTogetherCondition implements Condition {
	private int indexLast;
	private int indexBeforeLast;
	private int indexSecondLast;
	private final String CANDIDATE_SYMBOLS = "!@#$%~_^&*/(/)///-/+/=/[/]/{/}/|/`?><.,";

	@Override
	public boolean testCondition(List<Character> list, char charToAdd) {
		if (isListSmallerThan(list, 2)) {
			return false;
		} else if (isListSmallerThan(list, 3)) {
			return lastTwoSameSort(list);
		}
		return lastThreeSameSort(list);

	}

	public boolean lastThreeSameSort(List<Character> list) {
		return lastThreeLetter(list) || lastThreeDigits(list) || lastThreeSymbols(list);
	}

	public boolean lastTwoSameSort(List<Character> list) {
		return lastTwoLetter(list) || lastTwoDigit(list) || lastTwoSymbol(list);
	}

	public boolean lastThreeSymbols(List<Character> list) {
		try {
			indexLast = list.size() - 1;
			indexBeforeLast = list.size() - 2;
			indexSecondLast = list.size() - 3;

			return (charIsSymbol(list.get(indexLast)) && charIsSymbol(list.get(indexBeforeLast))
					&& charIsSymbol(list.get(indexSecondLast)));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean lastThreeDigits(List<Character> list) {
		try {
		indexLast = list.size() - 1;
		indexBeforeLast = list.size() - 2;
		indexSecondLast = list.size() - 3;

		return (Character.isDigit(indexLast) && Character.isDigit(indexBeforeLast)
				&& Character.isDigit(indexSecondLast));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean lastThreeLetter(List<Character> list) {
		try {
		indexLast = list.size() - 1;
		indexBeforeLast = list.size() - 2;
		indexSecondLast = list.size() - 3;

		return (Character.isLetter(indexLast) && Character.isLetter(indexBeforeLast)
				&& Character.isLetter(indexSecondLast));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean lastTwoLetter(List<Character> list) {
		try {
		indexLast = list.size() - 1;
		indexBeforeLast = list.size() - 2;

		return (Character.isLetter(indexLast) && Character.isLetter(indexBeforeLast));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean lastTwoDigit(List<Character> list) {
		try {
		indexLast = list.size() - 1;
		indexBeforeLast = list.size() - 2;

		return (Character.isDigit(indexLast) && Character.isDigit(indexBeforeLast));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean lastTwoSymbol(List<Character> list) {
		try {
		indexLast = list.size() - 1;
		indexBeforeLast = list.size() - 2;

		return ((!Character.isDigit(indexLast) && !Character.isLetter(indexLast))
				&& (!Character.isDigit(indexBeforeLast) && !Character.isLetter(indexBeforeLast)));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean charIsSymbol(Character c) {
		return CANDIDATE_SYMBOLS.contains(Character.toString(c));

	}

	public boolean isListSmallerThan(List<Character> list, int size) {
		return list.size() < size;
	}

}
