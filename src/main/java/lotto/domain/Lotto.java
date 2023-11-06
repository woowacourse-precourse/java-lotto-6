package lotto.domain;

import java.util.List;
import java.util.StringJoiner;

import lotto.util.message.ErrorMessage;

public class Lotto {

	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	public static final int LOTTO_SIZE = 6;
	public static final String PREFIX = "[";
	public static final String SUFFIX = "]";
	public static final String DELIMITER = ", ";

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		validateSize(numbers);
		validateDuplicateNumber(numbers);
		validateNumberOutOfRange(numbers);
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.getFormattedMessage(LOTTO_SIZE));
		}
	}

	private void validateDuplicateNumber(List<Integer> numbers) {
		if (numbers.stream().distinct().count() != numbers.size()) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
		}
	}

	private void validateNumberOutOfRange(List<Integer> numbers) {
		if (numbers.stream().anyMatch(this::isNumberOutOfRange)) {
			throw new IllegalArgumentException(
					ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getFormattedMessage(MIN_NUMBER, MAX_NUMBER));
		}
	}

	protected boolean isNumberOutOfRange(int number) {
		return number > MAX_NUMBER || number < MIN_NUMBER;
	}

	public String printNumbers() {
		StringJoiner strJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);

		for (Integer number : numbers) {
			strJoiner.add(String.valueOf(number));
		}

		return strJoiner.toString();
	}

	public boolean isContain(int number) {
		return numbers.contains(number);
	}

	public int getNumber(int index) {
		return numbers.get(index);
	}

	public int getSize() {
		return numbers.size();
	}
}
