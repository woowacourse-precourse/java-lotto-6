package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	
	private final String IS_SIX_DIGIT_MESSAGE = "복권 번호는 6개의 숫자여야 합니다.";
	private final String IS_NUMBER_RANGE_1_TO_45_MESSAGE = "복권 번호의 범위는 1~45 사이의 값이여야 합니다.";
	private final String IS_DUPLICATION_MESSAGE = "복권 번호는 중복되어서는 안됩니다.";
	
	private final String ERROR_MESSAGE_TAG = "[ERROR] ";
	private final int NUMBER_OF_LOTTO = 6;
	private final int MIN_LOTTO_NUMBER = 1;
	private final int MAX_LOTTO_NUMBER = 45;
	
	
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}
	
	public List<Integer> getNumbers(){
		return numbers;
	}

	private void validate(List<Integer> numbers) {
		if (!isSixDigit(numbers))
			throw new IllegalArgumentException(ERROR_MESSAGE_TAG+IS_SIX_DIGIT_MESSAGE);
		if (!isNumbersRange1to45(numbers))
			throw new IllegalArgumentException(ERROR_MESSAGE_TAG+IS_NUMBER_RANGE_1_TO_45_MESSAGE);
		if (!isDuplication(numbers))
			throw new IllegalArgumentException(ERROR_MESSAGE_TAG+IS_DUPLICATION_MESSAGE);
	}

	private boolean isSixDigit(List<Integer> numbers) {
		return numbers.size() == NUMBER_OF_LOTTO;
	}

	private boolean isNumbersRange1to45(List<Integer> numbers) {
		for (int number : numbers) {
			if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)
				return false;
		}
		return true;
	}

	private boolean isDuplication(List<Integer> numbers) {
		return sizeSet(numbers) == numbers.size();
	}

	private int sizeSet(List<Integer> numbers) {
		Set<Integer> setNumbers = new HashSet<Integer>(numbers);
		return setNumbers.size();
	}
}
