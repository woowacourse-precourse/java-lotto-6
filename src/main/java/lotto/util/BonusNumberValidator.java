package lotto.util;

public class BonusNumberValidator {
	public void validateBonusNumber(String input) {
		validateInteger(input);
		validateNumberRange(input);
	}

	private void validateInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUM_NOT_INTEGER_MESSAGE);
		}
	}

	private void validateNumberRange(String input) {
		if (Integer.parseInt(input) < Constant.LOTTO_MIN_NUMBER || Integer.parseInt(input) > Constant.LOTTO_MAX_NUMBER) {
			throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUM_OUT_OF_RANGE_MESSAGE);
		}
	}
}
