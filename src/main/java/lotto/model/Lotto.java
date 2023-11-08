package lotto.model;

import lotto.view.OutputView;

import java.util.List;
import java.util.function.Predicate;

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
	}

	public boolean contains(int number) {
		return numbers.contains(number);
	}

	public void printLotto(List<Integer> lotto) {
		OutputView.printLotto(lotto);
	}

	public int countNumberList(List<Integer> lottoNumbers) {
		return (int) numbers.stream()
				.filter(number -> lottoNumbers.stream()
						.anyMatch(Predicate.isEqual(number)))
				.count();
	}
}
