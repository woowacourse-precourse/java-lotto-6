package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) { // 사용자가 입력한 값을 넣을때 사용해야함
		validate(numbers);
		checkDuplicate(numbers);
		this.numbers = numbers;

	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	private void checkDuplicate(List<Integer> numbers) {
		Set<Integer> duplicateNumbers = new HashSet<>();
		for (Integer num : numbers) {
			if (num < 1 || num > 45 || !duplicateNumbers.add(num)) {
				throw new IllegalArgumentException();
			}
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

}