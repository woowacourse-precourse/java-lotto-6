package lotto.validation.validators;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class EmptyInput implements LottoGameValidator<String> {
	@Override
	public void validate(String value) {
		if (value.isEmpty()) {
			throw new LottoException(ErrorMessage.EMPTY_INPUT);
		}
	}
}
