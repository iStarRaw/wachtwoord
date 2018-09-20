package ilsa.wachtwoord.conditions;

import java.util.List;

public interface Condition {
	
	boolean testCondition(List<Character> list, char charToAdd);
	

}
