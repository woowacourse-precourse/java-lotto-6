package lotto.util.validator;

import java.util.regex.Pattern;

public class Validator {

	private Validator() {
		throw new AssertionError();
	}

	public static void validateSpecificFormat(Pattern pattern, String confirmationTarget, String message) {
		if (!pattern.matcher(confirmationTarget).matches()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validateIsEmpty(String confirmationTarget, String message) {
		if (isEmpty(confirmationTarget)) {
			throw new IllegalArgumentException(message);
		}
	}

	private static boolean isEmpty(String confirmationTarget) {
		return confirmationTarget == null || confirmationTarget.isBlank();
	}
}