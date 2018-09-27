package ilsa.wachtwoord.conditions;

import java.util.List;

public class SequenceCondition implements Condition {
	
	
	@Override
	public boolean testCondition(List<Character> list, char charToAdd) {
		if (list.size() < 3) {
			return false;
		}
		
		for (int i = 0; i < list.size() - 1; i++) {
			int indexPlusOne = i + 1; //4
			int indexMinusOne = i - 1; //2
			
			if (indexMinusOne < 0) { //false
				continue;
			} else if ((int)list.get(i) == (int)list.get(indexPlusOne) + 1 && (int)list.get(indexPlusOne) == (int)charToAdd) { //oplopend 3, 4, charToAdd
				return true;
			} else if ((int)charToAdd == (int)list.get(i) + 1 && (int)list.get(indexMinusOne) + 2 == (int)charToAdd) { //aflopend charToAdd, 4, 
				return true;
			}
		}
		return false;
	}
	

	
	
	
}
