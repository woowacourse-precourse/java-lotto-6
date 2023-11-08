package lotto.util;

public class LottoNumberValidator {
	public void validateLottoNumber(String input) {
		validateNumberCount(input);
		validateNumberRange(input);
	}

	private void validateNumberCount(String input) {
		if (input.split(",").length != Constant.LOTTO_SIZE) {
			throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUM_SIZE_MESSAGE);
		}
	}

	private void validateNumberRange(String input) {
		for (String number : input.split(",")) {
			if (Integer.parseInt(number) < Constant.LOTTO_MIN_NUMBER || Integer.parseInt(number) > Constant.LOTTO_MAX_NUMBER) {
				throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUM_OUT_OF_RANGE_MESSAGE);
			}
		}
	}
}
