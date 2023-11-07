package lotto.validation;

import static lotto.exception.ExceptionMessage.*;

import lotto.exception.MoneyException;

public class NumberValidator {
	public static void validateNumber(String input) {
		if (isNotNumeric(input)) {
			throw new MoneyException(INVALID_NUMBER.getMessage());
		}
	}

	public static void validatePositive(int input) {
		if (!isPositive(input)) {
			throw new MoneyException(MONEY_POSITIVE_ERROR.getMessage());
		}
	}

	private static boolean isNotNumeric(String input) {
		return !input.matches("[0-9]+");
	}

	private static boolean isPositive(int input) {
		return input > 0;
	}
}
