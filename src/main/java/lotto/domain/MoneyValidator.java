package lotto.domain;

import static lotto.exception.ExceptionMessage.INVALID_NUMBER;

import lotto.exception.MoneyException;

public class MoneyValidator {
	public void validateNumber(String input) {
		if (isNotNumeric(input)) {
			throw new MoneyException(INVALID_NUMBER.getMessage());
		}
	}

	private static boolean isNotNumeric(String input) {
		return !input.matches("[0-9]+");
	}
}
