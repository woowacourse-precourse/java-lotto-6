package lotto.lotto;

import lotto.exception.ExceptionInfo;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_END_NUMBER = 45;

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		validateSize(numbers);

		validateDuplicatedNumber(numbers);
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(ExceptionInfo.LOTTO_NUMBERS_OVER_SIX.getMessage());
		}
	}

	private void validateDuplicatedNumber(List<Integer> numbers) {
		List<Integer> validNumbers = new ArrayList<>();

		for (Integer number : numbers) {
			validateInRange(number);
			if (validNumbers.contains(number)) {
				throw new IllegalArgumentException(ExceptionInfo.DUPLICATED_LOTTO_NUMBER.getMessage());
			}
			validNumbers.add(number);
		}
	}

	private void validateInRange(Integer number) {
		if (number < LOTTO_START_NUMBER  || LOTTO_END_NUMBER < number) {
			throw new IllegalArgumentException(ExceptionInfo.OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	// TODO: 추가 기능 구현
}
