package lotto.util;

public class PurchaseValidator {
	public void validatePurchaseAmount(String input) {
		validateInteger(input);
		validateRange(input);
	}

	private void validateInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_NOT_INTEGER_MESSAGE);
		}
	}

	private void validateRange(String input) {
		if (Integer.parseInt(input) < Constant.LOTTO_PRICE) {
			throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_OUT_OF_RANGE_MESSAGE);
		}
	}
}
