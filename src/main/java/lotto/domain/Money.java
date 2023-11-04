package lotto.domain;

import lotto.util.message.ErrorMessage;

public record Money(int money) {

	public static final int UNIT = 1000;

	public Money {
		validateMoneyUnit(money);
	}

	private static void validateMoneyUnit(int money) {
		if (money % UNIT != 0) {
			throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR.getForMatMessage(UNIT));
		}
	}

	public int getBuyedCount() {
		return money / UNIT;
	}
}