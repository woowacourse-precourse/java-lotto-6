package lotto.util;

public class LottoNumberValidator {
	public void validateLottoNumber(String input) {

	}

	private void checkInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUM_NOT_INTEGER_MESSAGE);
		}
	}
}
