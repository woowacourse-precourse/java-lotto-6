package lotto.model;

import lotto.global.util.Constants;
import lotto.view.ErrorMessages;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != Constants.LOTTO_NUMBER_COUNT.value) {
			throw new IllegalArgumentException();
		}
		int size = numbers.stream()
						  .distinct()
						  .toList()
						  .size();

		if (size != Constants.LOTTO_NUMBER_COUNT.value) {
			throw new IllegalArgumentException(ErrorMessages.NUMBER_DUPLICATION.message);
		}
	}


	public boolean isBonusMatch(int bonusNumber) {
		return numbers.contains(bonusNumber);
	}

	public int getMatchResult(List<Integer> numbers) {
		return Long.valueOf(this.numbers.stream()
										.filter(numbers::contains)
										.count()).intValue();
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}