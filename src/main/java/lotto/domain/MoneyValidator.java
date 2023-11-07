package lotto.domain;

import static lotto.constant.GameRule.*;
import static lotto.exception.ExceptionMessage.*;

import lotto.exception.MoneyException;

public class MoneyValidator {
	public void validateNumber(String input) {
		if (isNotNumeric(input)) {
			throw new MoneyException(INVALID_NUMBER.getMessage());
		}
	}

	public void validatePositive(int input) {
		if (!isPositive(input)) {
			throw new MoneyException(MONEY_POSITIVE_ERROR.getMessage());
		}
	}

	public void validateUnit(int input) {
		if (!isRuleUnit(input)) {
			throw new MoneyException(MONEY_UNIT_ERROR.getMessage());
		}
	}

	private static boolean isNotNumeric(String input) {
		return !input.matches("[0-9]+");
	}

	private boolean isPositive(int input) {
		return input > 0;
	}

	private boolean isRuleUnit(int input) {
		return input % MONEY_UNIT == 0;
	}
}
