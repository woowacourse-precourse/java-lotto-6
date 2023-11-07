package lotto.domain;

import static lotto.constant.LottoConstant.*;
import static lotto.exception.ErrorMessage.*;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		validateSize(numbers);
		validateDuplication(numbers);
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != PICK_COUNT.getValue()) {
			throw new IllegalArgumentException(INPUT_COUNT_ERROR.getMessage());
		}
	}

	private void validateDuplication(List<Integer> numbers) {
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
