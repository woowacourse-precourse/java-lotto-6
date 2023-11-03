package lotto;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) { // 사용자가 입력한 값을 넣을때 사용해야함
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
	
}