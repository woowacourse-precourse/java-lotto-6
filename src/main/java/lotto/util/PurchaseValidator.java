package lotto.util;

public class PurchaseValidator {
	public void validatePurchaseAmount(String input) {
		validateInteger(input);
	}

	private void validateInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_NOT_INTEGER_MESSAGE);
		}
	}
}
