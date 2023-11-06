package lotto;

import java.util.regex.Pattern;

public class InputValidator {
	public void isComposedOfNumbers(String cost) throws IllegalArgumentException {
		if (!Pattern.matches("^[0-9]+$", cost)) {
			throw new IllegalArgumentException();
		}
	}

}
