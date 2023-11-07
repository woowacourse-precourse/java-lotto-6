package lotto.validation;

import static lotto.exception.ExceptionMessage.*;

import lotto.exception.MoneyException;

public class NumberValidator {
	public static void validateIntType(String input) {
		if (isIntType(input)) {
			throw new MoneyException(INVALID_NUMBER.getMessage());
		}
	}

	public static void validatePositive(int input) {
		if (!isPositive(input)) {
			throw new MoneyException(MONEY_POSITIVE_ERROR.getMessage());
		}
	}

	private static boolean isIntType(String input) {
		return !input.matches("-?\\d+");
	}

	private static boolean isPositive(int input) {
		return input > 0;
	}
}
