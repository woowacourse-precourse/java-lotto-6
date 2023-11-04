package lotto.domain;

import static lotto.config.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.config.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.config.ErrorMessage.INVALID_LOTTO_SIZE;
import static lotto.config.LottoConfig.LOTTO_SIZE;
import static lotto.config.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.config.LottoConfig.MIN_LOTTO_NUMBER;

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
		if (!checkSize(numbers)) {
			throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
		}

		if (!checkNumberRange(numbers)) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
		}

		if (!checkDuplication(numbers)) {
			throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
		}
	}

	private boolean checkSize(List<Integer> numbers) {
		return numbers.size() == LOTTO_SIZE.getValue();
	}

	private boolean checkNumberRange(List<Integer> numbers) {
		for (int number : numbers) {
			if (number < MIN_LOTTO_NUMBER.getValue() || number > MAX_LOTTO_NUMBER.getValue()) {
				return false;
			}
		}

		return true;
	}

	private boolean checkDuplication(List<Integer> numbers) {
		long count = numbers.stream().distinct().count();

		return count == numbers.size();
	}
}