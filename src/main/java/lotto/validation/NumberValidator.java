package lotto.validation;

import static lotto.exception.ExceptionMessage.INVALID_NUMBER;
import static lotto.exception.ExceptionMessage.POSITIVE_NUMBER_ERROR;

public class NumberValidator {
	public static void validateIntType(String input) {
		if (isIntType(input)) {
			throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
		}
	}

	public static void validatePositive(int input) {
		if (!isPositive(input)) {
			throw new IllegalArgumentException(POSITIVE_NUMBER_ERROR.getMessage());
		}
	}

	private static boolean isIntType(String input) {
		return !input.matches("-?\\d+");
	}

	private static boolean isPositive(int input) {
		return input > 0;
	}
}
