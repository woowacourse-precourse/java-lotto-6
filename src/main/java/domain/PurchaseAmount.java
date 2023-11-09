package domain;

import exception.IllegalArgumentExceptionMessage;
import exception.NumberFormatExceptionMessage;

public class PurchaseAmount {
	private static final int THOUSAND_UNIT = 1000;
	private final int amount;
	private final int lottoPurchaseCount;

	public PurchaseAmount(String amount) {
		validateStringParameter(amount);

		int convertedAmount = convertStringToInt(amount);
		validateIntParameter(convertedAmount);

		this.amount = convertedAmount;
		this.lottoPurchaseCount = calculateLottoPurchaseCount(convertedAmount);
	}

	private void validateIntParameter(int convertedAmount) {
		validateIsPositive(convertedAmount);
		validateIsThousandUnit(convertedAmount);
	}

	private void validateStringParameter(String amount) {
		validateIsDigit(amount);
		validateIsEmpty(amount);
	}

	public int getAmount() {
		return amount;
	}

	public int getLottoPurchaseCount() {
		return lottoPurchaseCount;
	}

	private int calculateLottoPurchaseCount(int amount) {
		return amount / THOUSAND_UNIT;
	}

	private int convertStringToInt(String amount) {
		return Integer.parseInt(amount);
	}

	private void validateIsDigit(String amount) {
		if (!isDigit(amount)) {
			NumberFormatExceptionMessage.PURCHASE_AMOUNT_NUMBERS_ONLY.throwException();
		}
	}

	private void validateIsThousandUnit(int amount) {
		if (!(amount % THOUSAND_UNIT == 0)) {
			IllegalArgumentExceptionMessage.PURCHASE_AMOUNT_THOUSAND_UNIT.throwException();
		}
	}

	private boolean isDigit(String amount) {
		return amount.chars()
				.allMatch(Character::isDigit);
	}

	private void validateIsPositive(int amount) {
		if (!(amount > 0)) {
			IllegalArgumentExceptionMessage.PURCHASE_AMOUNT_NOT_EXCEED_ZERO.throwException();
		}
	}

	private void validateIsEmpty(String amount) {
		if (amount.isBlank()) {
			IllegalArgumentExceptionMessage.PURCHASE_AMOUNT_NUMERIC.throwException();
		}
	}
}
