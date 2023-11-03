package lotto.util.validator;

import java.util.regex.Pattern;

public class Validator {

	public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

	private Validator() {
		throw new AssertionError();
	}

	public static void validateNumberFormat(String inputValue, String message) {
		if (!NUMBER_PATTERN.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validateIsEmpty(String inputValue, String message) {
		if (isStringEmpty(inputValue)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void validateStrArrLength(String[] inputValue, int length, String message) {
		if (inputValue.length != length) {
			throw new IllegalArgumentException(message);
		}
	}

	private static boolean isStringEmpty(String str) {
		return str == null || str.isBlank();
	}
}
