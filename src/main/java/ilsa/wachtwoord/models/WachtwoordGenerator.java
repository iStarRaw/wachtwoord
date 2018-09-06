package ilsa.wachtwoord.models;

import java.security.SecureRandom;

public class WachtwoordGenerator {
	private final String CANDIDATE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%~_^&*/(/)///-/+/=/[/]/{/}/|/`?><.,";
	private SecureRandom secGenerator = new SecureRandom();
	
	
	
	
	
	
	
	/**
	 * Generates one random char. Extended ASCII: 0 - 255
	 * 
	 * @return char
	 */
	public char generateChar() {
		char randomChar = CANDIDATE_CHARS.charAt(secGenerator.nextInt(CANDIDATE_CHARS.length()));
		return randomChar;
	}

}
