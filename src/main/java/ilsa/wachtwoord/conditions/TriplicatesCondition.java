package ilsa.wachtwoord.conditions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriplicatesCondition implements Condition {
	private Map<Character, Integer> charCount;
	private final int MAX_COUNT = 3;

	public TriplicatesCondition() {
		charCount = new HashMap<Character, Integer>();
	}

	/**
	 * Checks whether the password contains the same char 3 times.
	 * 
	 * @param list
	 * @return boolean
	 */
	@Override
	public boolean testCondition(List<Character> list, char charToAdd) {
		int occurrences = 0;
		
		if (list.size() < 3) {
			return false;
		}
		
		for (int i = 0; i < list.size(); i++) {
			occurrences = Collections.frequency(list, list.get(i));
			if (occurrences == 3) {
				return true;
			}
		}
		return false;
	}

}
