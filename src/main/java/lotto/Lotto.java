package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		chk_duplication(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	public void chk_duplication(List<Integer> numbers) {
		Set<Integer> numSet = new HashSet<>(numbers);
		if (numSet.size() != numbers.size()) {
			throw new IllegalArgumentException();
		}
	}

	public List<Integer> get_LottoNum() {
		return numbers;
	}
}
