package ilsa.wachtwoord.conditions;

import java.util.List;

public class SameSortTogetherCondition implements Condition {

	private final String CANDIDATE_SYMBOLS = "!@#$%~_^&*/(/)///-/+/=/[/]/{/}/|/`?><.,";

	/**
	 * checks whether the first two characters (of a total of three characters) are
	 * of the same sort followed by another sort
	 */
	@Override
	public boolean testCondition(List<Character> list, char charToAdd) {
		// TODO aanpassen zodat hij meet of er 2 van hetzelfde soort geisoleerd staan
		// dus toevoegen wat zit er voor 2 dezelfde
		// ook toevoegen 4 dezelfde
		// method overloaden met String bijv getCondition zodat je weet welke wordt geschonden?
		if (firstTwoSameSort(list)) {
			if (firstTwoDigit(list)) {
				return !lastThreeDigits(list);
			} else if (firstTwoSymbol(list)) {
				return !lastThreeSymbol(list);
			} else if (firstTwoLetter(list)) {
				return !lastThreeLetter(list);
			}
		}
		return false;
	}

	/**
	 * Finds the name of the character sort of the first two digits if these are of
	 * the same sort.
	 * 
	 * @param list
	 * @return String
	 */
	public String findSortFirstTwo(List<Character> list) {
		if (firstTwoDigit(list)) {
			return "Digit";
		} else if (firstTwoSymbol(list)) {
			return "Symbol";
		}
		return "Letter";
	}

	public String findSortLastTwo(List<Character> list) {
		if (lastTwoDigit(list)) {
			return "Digit";
		} else if (lastTwoSymbol(list)) {
			return "Symbol";
		}
		return "Letter";
	}
	
	public boolean lastTwoSameSort(List<Character> list) {
		return lastTwoSymbol(list) || lastTwoLetter(list) || lastTwoDigit(list);
	}

	private boolean lastTwoLetter(List<Character> list) {
		try {
			if (Character.isLetter(list.get(list.size() - 2)) && Character.isLetter(list.get(list.size() - 1))) {
				return true;
			}
			return false;

		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	private boolean lastTwoSymbol(List<Character> list) {
		try {
			return charIsSymbol(list.get(list.size() - 1)) && charIsSymbol(list.get(list.size() - 2));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	private boolean lastTwoDigit(List<Character> list) {
		try {
			if (Character.isDigit(list.get(list.size() - 2)) && Character.isDigit(list.get(list.size() - 1))) {
				return true;
			}
			return false;

		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean lastFourSameSort(List<Character> list) {
		return lastFourLetter(list) || lastFourDigit(list) || lastFourSymbol(list);
	}

	public boolean lastThreeSameSort(List<Character> list) {
		return lastThreeLetter(list) || lastThreeDigits(list) || lastThreeSymbol(list);
	}

	//public voor test
	public boolean firstTwoSameSort(List<Character> list) {
		return firstTwoLetter(list) || firstTwoDigit(list) || firstTwoSymbol(list);
	}


	//public voor test
	public boolean lastThreeSymbol(List<Character> list) {
		try {
			return (charIsSymbol(list.get(list.size() - 1)) && charIsSymbol(list.get(list.size() - 2))
					&& charIsSymbol(list.get(list.size() - 3)));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	private boolean lastThreeDigits(List<Character> list) {
		try {
			return Character.isDigit(list.get(list.size() - 1)) && Character.isDigit(list.get(list.size() - 2))
					&& Character.isDigit(list.get(list.size() - 3));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}

	}

	
	private boolean lastThreeLetter(List<Character> list) {
		try {
			return Character.isLetter(list.get(list.size() - 1)) && Character.isLetter(list.get(list.size() - 2))
					&& Character.isLetter(list.get(list.size() - 3));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	//public voor test
	public boolean firstTwoLetter(List<Character> list) {
		try {
			if (Character.isLetter(list.get(list.size() - 3)) && Character.isLetter(list.get(list.size() - 2))) {
				return true;
			}
			return false;

		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	//public voor test
	public boolean firstTwoDigit(List<Character> list) {
		try {
			if (Character.isDigit(list.get(list.size() - 3)) && Character.isDigit(list.get(list.size() - 2))) {
				return true;
			}
			return false;

		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	//public voor test
	public boolean firstTwoSymbol(List<Character> list) {
		try {
			return !Character.isDigit(list.get(list.size() - 3)) && !Character.isLetter(list.get(list.size() - 3))
					&& !Character.isDigit(list.get(list.size() - 2)) && !Character.isLetter(list.get(list.size() - 2));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean firstTwoSameAndBeforeAsWell(List<Character> list) {
		return firstTwoDigitAndBeforeAsWell(list) || firstTwoLetterAndBeforeAsWell(list)
				|| firstTwoSymbolAndBeforeAsWell(list);
	}

	private boolean firstTwoLetterAndBeforeAsWell(List<Character> list) {
		try {
			return firstTwoLetter(list) && Character.isLetter(list.get(list.size() - 4));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	private boolean firstTwoDigitAndBeforeAsWell(List<Character> list) {
		try {
			return firstTwoDigit(list) && Character.isDigit(list.get(list.size() - 4));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	private boolean firstTwoSymbolAndBeforeAsWell(List<Character> list) {
		try {
			return firstTwoSymbol(list) && charIsSymbol(list.get(list.size() - 4));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	//public voor test
	public boolean charIsSymbol(Character c) {
		return CANDIDATE_SYMBOLS.contains(Character.toString(c));

	}

	private boolean lastFourSymbol(List<Character> list) {
		try {
			return charIsSymbol(list.get(list.size() - 1)) && charIsSymbol(list.get(list.size() - 2))
					&& charIsSymbol(list.get(list.size() - 3)) && charIsSymbol(list.get(list.size() - 4));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	private boolean lastFourDigit(List<Character> list) {
		try {
			return Character.isDigit(list.get(list.size() - 1)) && Character.isDigit(list.get(list.size() - 2))
					&& Character.isDigit(list.get(list.size() - 3)) && Character.isDigit(list.get(list.size() - 4));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	//public voor test
	public boolean lastFourLetter(List<Character> list) {
		try {
			return Character.isLetter(list.get(list.size() - 1)) && Character.isLetter(list.get(list.size() - 2))
					&& Character.isLetter(list.get(list.size() - 3)) && Character.isLetter(list.get(list.size() - 4));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

}
