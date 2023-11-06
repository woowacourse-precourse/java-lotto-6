package lotto.domain;

import lotto.util.message.ErrorMessage;

public record Money(int money) {

	public static final int UNIT = 1000;

	public Money {
		validate(money);
	}

	private void validate(int money) {
		validateZeroOrNegativeNumber(money);
		validateMoneyUnit(money);
	}

	private void validateZeroOrNegativeNumber(int money) {
		if (money <= 0) {
			throw new IllegalArgumentException(ErrorMessage.ZERO_OR_NEGATIVE_NUMBER_ERROR.getMessage());
		}
	}

	private void validateMoneyUnit(int money) {
		if (money % UNIT != 0) {
			throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR.getFormattedMessage(UNIT));
		}
	}

	public int getBuyedCount() {
		return money / UNIT;
	}
}