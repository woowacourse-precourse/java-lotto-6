package lotto.domain;

import static lotto.constant.GameRule.MONEY_UNIT;

public class InputAmount {
	private final int inputAmount;

	public InputAmount(int input) {
		this.inputAmount = convertToAmount(input);
	}

	public int getInputAmount() {
		return this.inputAmount;
	}

	private int convertToAmount(int input) {
		return input / MONEY_UNIT;
	}
}
