package lotto.validator;

import static lotto.constants.MessageConstants.INPUT_DUPLICATION;
import static lotto.constants.MessageConstants.INPUT_NUMBER6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		duplicationValidate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(INPUT_NUMBER6);
		}
	}

	private void duplicationValidate(List<Integer> numbers) {
		Set<Integer> noDuplicationNum = new HashSet<>(numbers);
		if (noDuplicationNum.size() != numbers.size()) {
			throw new IllegalArgumentException(INPUT_DUPLICATION);
		}
	}

}
