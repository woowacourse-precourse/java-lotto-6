package lotto.validation.validators;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class DuplicateNumber implements LottoGameValidator<List<Integer>> {
	@Override
	public void validate(List<Integer> value) {
		if (value.size() != distinctCount(value)) {
			throw new LottoException(ErrorMessage.DUPLICATED_NUMBER);
		}
	}

	private int distinctCount(List<Integer> value) {
		return (int) value.stream()
				.distinct()
				.count();
	}
}
