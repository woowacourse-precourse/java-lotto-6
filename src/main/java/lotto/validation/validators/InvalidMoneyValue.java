package lotto.validation.validators;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class InvalidMoneyValue implements LottoGameValidator<Integer> {
	@Override
	public void validate(Integer value) {
		if (value < 0) {
			throw new LottoException(ErrorMessage.INVALID_MONEY);
		}
	}
}
