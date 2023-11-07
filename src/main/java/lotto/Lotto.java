package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.enums.LottoError;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		List<Integer> sortedNumbers = new ArrayList<>(numbers);
		Collections.sort(sortedNumbers);
		this.numbers = sortedNumbers;
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

	public List<Integer> getNumbers() {
		return this.numbers;
	}
}
