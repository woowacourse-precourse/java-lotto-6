package lotto.validator;

import lotto.view.ExceptionMessage;

public class AmountValidator {
	private static final int LOTTO_MIN_AMOUNT = 1000;
	private static final String NUMBER_EXCEPTION = "[ERROR] 금액은 숫자만 등록 가능합니다.";
	private static final String NATURAL_NUMBER_EXCEPTION = "[ERROR] 금액은 0 초과이어야 합니다.";
	private static final String DIVISIBLE_NUMBER_EXCEPTION = "[ERROR] 금액은 " + LOTTO_MIN_AMOUNT + "단위여야 합니다.";

	private AmountValidator() {

	}

	public static void validateAmount(int amount) {
		validateNatural(amount);
		validateDivisible(amount);
	}

	public static int validateNumber(String amount) throws IllegalArgumentException {
		try {
			return Integer.parseInt(amount);
		} catch (NumberFormatException e) {
			ExceptionMessage.numberException();
			throw new IllegalArgumentException(NUMBER_EXCEPTION);
		}
	}

	public static void validateNatural(int amount) {
		if (amount <= 0) {
			ExceptionMessage.naturalException();
			throw new IllegalArgumentException(NATURAL_NUMBER_EXCEPTION);
		}
	}

	public static void validateDivisible(int amount) {
		if (amount % LOTTO_MIN_AMOUNT != 0) {
			ExceptionMessage.divisibleException();
			throw new IllegalArgumentException(DIVISIBLE_NUMBER_EXCEPTION);
		}
	}
}
