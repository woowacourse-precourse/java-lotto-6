package lotto.domain;

import static lotto.constant.GameRule.*;
import static lotto.exception.ExceptionMessage.*;

import lotto.validation.NumberValidator;

public class InputMoney {
	private final int inputMoney;

	public InputMoney(String input) {
		this.inputMoney = validateMoney(input);
	}

	public int getInputMoney() {
		return this.inputMoney;
	}

	private int validateMoney(String input) {
		NumberValidator.validateIntType(input);
		int inputMoney = Integer.parseInt(input);

		NumberValidator.validatePositive(inputMoney);
		validateUnit(inputMoney);
		return inputMoney;
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
