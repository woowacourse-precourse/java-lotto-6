package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
	private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
		Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || !areUnique(numbers) || !areInRange(numbers)) {
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

}
