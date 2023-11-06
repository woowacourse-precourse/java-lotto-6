package lotto.util.validator;

import java.util.regex.Pattern;

public class Validator {

	public static final Pattern NUMBER_PATTERN = Pattern.compile("^-?\\d+$");

	private Validator() {
		throw new AssertionError();
	}

	public static void validateNumberFormat(String inputValue, String message) {
		if (!NUMBER_PATTERN.matcher(inputValue).matches()) {
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
