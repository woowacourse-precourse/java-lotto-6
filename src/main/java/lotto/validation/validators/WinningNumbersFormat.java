package lotto.validation.validators;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class WinningNumbersFormat implements LottoGameValidator<String> {
	private static final String WINNING_NUMBERS_FORMAT = "(\\d{1,5},){1,10}(\\d{1,5})";

	@Override
	public void validate(String value) {
		if (isValidFormat(value)) {
			throw new LottoException(ErrorMessage.WINNING_NUMBERS_FORMAT);
		}
	}

	private boolean isValidFormat(String value) {
		return !value.matches(WINNING_NUMBERS_FORMAT);
	}
}
