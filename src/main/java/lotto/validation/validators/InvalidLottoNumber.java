package lotto.validation.validators;

import lotto.domain.constant.LottoValue;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class InvalidLottoNumber extends LottoValue implements LottoGameValidator<Integer> {
	@Override
	public void validate(Integer value) {
		if (outOfBounds(value)) {
			throw new LottoException(ErrorMessage.INVALID_LOTTO_NUMBER);
		}
	}

	private boolean outOfBounds(int value) {
		return !(value >= MINIMUM_INCLUSIVE_NUMBER && value <= MAXIMUM_INCLUSIVE_NUMBER);
	}
}
