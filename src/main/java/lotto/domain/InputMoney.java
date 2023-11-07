package lotto.domain;

import static lotto.constant.GameRule.*;
import static lotto.exception.ExceptionMessage.*;

import lotto.validation.NumberValidator;

public class InputMoney {
	private final int inputMoney;

	public InputMoney(String input) {
		this.inputMoney = validateAndConvertToInt(input);
	}

	public int getInputMoney() {
		return this.inputMoney;
	}

	private int validateAndConvertToInt(String input) {
		NumberValidator.validateIntType(input);
		NumberValidator.validatePositive(Integer.parseInt(input));
		validateUnit(Integer.parseInt(input));
		return Integer.parseInt(input);
	}

	public void validateUnit(int input) {
		if (isNotRuleUnit(input)) {
			throw new IllegalArgumentException(MONEY_UNIT_ERROR.getMessage());
		}
	}

	private boolean isNotRuleUnit(int input) {
		return !(input % MONEY_UNIT == 0);
	}
}
