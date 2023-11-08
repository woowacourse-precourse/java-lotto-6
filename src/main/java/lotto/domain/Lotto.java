package lotto.domain;

import java.util.Collections;
import java.util.List;

import lotto.utils.Constants;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}

		for (Integer number : numbers) {
			if (Collections.frequency(numbers, number) >= 2) {
				throw new IllegalArgumentException();
			}
		}

		if (Collections.max(numbers) > Constants.LOTTO_MAX_NUMBER || Collections.min(numbers) < Constants.LOTTO_MIN_NUMBER) {
			throw new IllegalArgumentException();
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public String toString() {
		return numbers.toString();
	}
}
