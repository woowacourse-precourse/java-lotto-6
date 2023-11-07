package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) throws IllegalArgumentException {
		isThisSizeSix(numbers);
		existDuplicateNumber(numbers);
	}

	private void isThisSizeSix(List<Integer> numbers) throws IllegalArgumentException {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(ErrorCode.ELEMENTS_SHOULD_BE_SIX.getErrorMessage());
		}
	}

	private void existDuplicateNumber(List<Integer> numbers) throws IllegalArgumentException {
		Set<Integer> checkNumbers = new HashSet<>(numbers);
		if (checkNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException(ErrorCode.NOT_ALLOW_DUPLICATE.getErrorMessage());
		}
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}
}
