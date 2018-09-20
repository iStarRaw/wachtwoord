package ilsa.wachtwoord.conditions;

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
		// TODO aanpassen voor het checken voordat de char wordt toegevoegd

		for (Character c : charCount.keySet()) {
			Integer count = charCount.get(c);
			charCount.put(c, (count == null) ? 1 : count + 1);

			if (charCount.containsValue(MAX_COUNT)) {
				return true;
			}
		}
		return false;

	}

}
