package lotto.validation.validators;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class NonIntegerInput implements LottoGameValidator<String> {
	@Override
	public void validate(String value) {
		try {
			Integer.parseInt(value);
		} catch (Exception e) {
			throw new LottoException(ErrorMessage.STRING_NOT_ALLOWED);
		}
	}
}
