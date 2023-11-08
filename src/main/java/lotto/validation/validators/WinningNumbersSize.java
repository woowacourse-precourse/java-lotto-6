package lotto.validation.validators;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class WinningNumbersSize implements LottoGameValidator<List<Integer>> {
	@Override
	public void validate(List<Integer> value) {
		if (value.size() != 6) {
			throw new LottoException(ErrorMessage.INVALID_WINNING_NUMBERS_SIZE);
		}
	}
}
