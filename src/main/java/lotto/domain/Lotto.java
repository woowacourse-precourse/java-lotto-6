package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.common.ErrorType;

public class Lotto {

	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;
	public static final int MAX_LOTTO_SIZE = 6;

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers.stream()
			.sorted().collect(Collectors.toList());
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != MAX_LOTTO_SIZE
			|| !areUnique(numbers) || !areInRange(numbers)) {
			throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_NUMBER.getErrorMessage());
		}
	}

	// TODO: 추가 기능 구현
	private boolean areUnique(List<Integer> numbers) {
		return numbers.stream()
			.distinct().count() == numbers.size();
	}

	private boolean areInRange(List<Integer> numbers) {
		return numbers.stream()
			.allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER);
	}

	@Override
	public String toString() {
		return "" + numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

}
