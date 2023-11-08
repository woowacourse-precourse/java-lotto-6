package lotto;

import java.util.List;

public class Lotto {
	static int count = 0;
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}


	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public String toString() {
		return numbers.toString();
	}

	public int contains(int num) {
		if (numbers.contains(num)) {
			count++;
		}
		return count;
	}


}
