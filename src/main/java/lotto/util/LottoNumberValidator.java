package lotto.util;

public class LottoNumberValidator {
	public void validateLottoNumber(String input) {
		validateNumberCount(input);
	}

	private void validateNumberCount(String input) {
		if (input.split(",").length != Constant.LOTTO_SIZE) {
			throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUM_SIZE_MESSAGE);
		}
	}
}
