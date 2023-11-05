package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.enums.LottoError;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		validateSize(numbers);
		validateRange(numbers);
		validateRedundant(numbers);
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(LottoError.INVALID_SIZE_INPUT.getErrorDescription());
		}
	}

	private void validateRange(List<Integer> numbers) {
		for (int num : numbers) {
			if (num < 1 || num > 45) {
				throw new IllegalArgumentException(LottoError.INVALID_RANGE_INPUT.getErrorDescription());
			}
		}
	}

	private void validateRedundant(List<Integer> numbers) {
		Set<Integer> NotRedundantNumbers = new HashSet<>(numbers);
		if (numbers.size() != NotRedundantNumbers.size()) {
			throw new IllegalArgumentException(LottoError.INVALID_REDUNDANT_INPUT.getErrorDescription());
		}
	}
}
