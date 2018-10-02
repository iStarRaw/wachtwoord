package ilsa.wachtwoord.conditions;

import java.util.Collections;
import java.util.List;

public class TriplicatesCondition implements Condition {

	/**
	 * Checks whether the password contains the same char 3 times.
	 * 
	 * @param list
	 * @return boolean
	 */
	@Override
	public boolean testCondition(List<Character> list, char charToAdd) {
		if (list.size() < 3) {
			return false;
		}
		
		int occurrences = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == charToAdd) {
				occurrences++;
			}
		}

		if (occurrences == 3) {
			return true;
		}
		return false;
	}
}
