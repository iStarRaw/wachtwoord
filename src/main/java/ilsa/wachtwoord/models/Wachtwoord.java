package ilsa.wachtwoord.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Wachtwoord {
	private List<Character> password;
	private int maxChar;
	private int index_last;
	private int index_max;

	public Wachtwoord() {
		password = new ArrayList<>();
	}

	public Wachtwoord(int maxChar) {
		this.maxChar = maxChar;
		password = new ArrayList<>(this.maxChar);
		index_max = maxChar - 1;
	}

	public List<Character> getPassword() {
		return this.password;
	}

	public int getMaxChar() {
		return this.maxChar;
	}

	public int getIndex_max() {
		return index_max;
	}

	/**
	 * Adds a char to the password
	 * 
	 * @param c
	 */
	public void addCharToPassword(char charToAdd) {
		this.password.add(charToAdd);

		index_last = this.password.size() - 1;
	}

	public void getLastChar() {
		this.password.get(index_last);
	}

	public void removeLastChar() {
		this.password.remove(index_last);
	}
	
	
	@Override
	public String toString() {
		return this.password.stream().map(e -> e.toString()).collect(Collectors.joining());
	}

	// TODO removeLast()
}
