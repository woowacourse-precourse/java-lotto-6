package lotto.domain;

import static lotto.constant.LottoConstant.*;
import static lotto.exception.ErrorMessage.*;
import static lotto.view.OutputView.*;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	private void validate(List<Integer> numbers) {
		try {
			validateSize(numbers);
			validateRange(numbers);
			validateDuplication(numbers);
		} catch (IllegalArgumentException e) {
			printErrorMessage(e.getMessage());
			throw e;
		}

	}

	private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
		if (numbers.size() != PICK_COUNT.getValue()) {
			throw new IllegalArgumentException(INPUT_COUNT_ERROR.getMessage());
		}
	}

	private void validateRange(List<Integer> numbers) throws IllegalArgumentException {
		for (int number : numbers) {
			if (number < MIN_LOTTO_NUMBER.getValue() || MAX_LOTTO_NUMBER.getValue() < number) {
				throw new IllegalArgumentException(RANGE_ERROR.getMessage());
			}
		}
	}

	private void validateDuplication(List<Integer> numbers) throws IllegalArgumentException {
		if (numbers.stream().distinct().count() != PICK_COUNT.getValue()) {
			throw new IllegalArgumentException(DUPLICATED_ERROR.getMessage());
		}
	}

	public boolean contains(int number) {
		return this.numbers.contains(number);
	}

	public int getMatchCount(List<Integer> winningNumbers) {
		return (int)winningNumbers.stream()
			.filter(this.numbers::contains)
			.count();
	}

	@Override
	public String toString() {
		return this.numbers.toString();
	}
}
