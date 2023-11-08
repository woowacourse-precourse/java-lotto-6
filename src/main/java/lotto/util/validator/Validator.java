package lotto.util.validator;

import java.util.regex.Pattern;

public class Validator {

	private Validator() {
		throw new AssertionError();
	}

	public static void validateSpecificFormat(Pattern pattern, String inputValue, String message) {
		if (!pattern.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validateIsEmpty(String inputValue, String message) {
		if (isEmpty(inputValue)) {
			throw new IllegalArgumentException(message);
		}
	}

	private static boolean isEmpty(String str) {
		return str == null || str.isBlank();
	}
}