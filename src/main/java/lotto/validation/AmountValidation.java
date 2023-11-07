package lotto.validation;

import static lotto.system.ExceptionMessage.AMOUN_VALIDATION_ERROR_MESSAGE;

public class AmountValidation {
	public static void isAmountCorrect(int amount) {
		isZero(amount);
		isUnitsOfThousand(amount);
		isUnderThousand(amount);
	}
	
	private static void isZero(int amount) {
		if (amount == 0) {
			throw new IllegalArgumentException(AMOUN_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}

	private static void isUnitsOfThousand(int amount) {
		if (amount % 1000 != 0) {
			throw new IllegalArgumentException(AMOUN_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}
	
	private static void isUnderThousand(int amount) {
		if (amount < 1000) {
			throw new IllegalArgumentException(AMOUN_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}
}