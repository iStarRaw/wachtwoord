package ilsa.wachtwoord.conditions;

import java.util.List;

public class LengthCondition implements Condition {
	private int numberOfChars = 8;
	
	public LengthCondition() {
//		ww.setLength(numberOfChars);
	}

	@Override
	public boolean testCondition(List<Character> list,  char charToAdd) {
		// TODO Auto-generated method stub
		return false;
	}

}
