package domain;

import java.util.List;
import java.util.stream.Collectors;

import exception.IllegalArgumentExceptionMessage;
import exception.NumberFormatExceptionMessage;

public class Lotto {
	private static final int LOTTO_SIZE = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		validateListIntegerParameter(numbers);
		this.numbers = numbers;
	}

	public Lotto(String numbers) {
		List<String> parsedNumbers = convertStringToList(removeSpacesBetweenNumbersAndCommas(numbers));
		validateListStringParameter(parsedNumbers);

		List<Integer> validatedAndParsedNumbers = convertStringListToIntegerList(parsedNumbers);
		validateListIntegerParameter(validatedAndParsedNumbers);
		this.numbers = validatedAndParsedNumbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public String removeSpacesBetweenNumbersAndCommas(String numbers) {
		return numbers.replace(" ", "");
	}

	public String getLottoNumbersAsString() {
		return this.numbers.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(", "));
	}

	private void validateListStringParameter(List<String> parsedNumbers) {
		validateIsDigit(parsedNumbers);
		validateIsSixLength(parsedNumbers);
	}

	private void validateListIntegerParameter(List<Integer> validatedAndParsedNumbers) {
		validateIsBetweenLottoRange(validatedAndParsedNumbers);
		validateDuplicateNumber(validatedAndParsedNumbers);
	}

	private List<Integer> convertStringListToIntegerList(List<String> numbers) {
		return numbers.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	private void validateIsSixLength(List<String> numbers) {
		if (!isSixLength(numbers)) {
			IllegalArgumentExceptionMessage.LOTTO_WRONG_FORMAT.throwException();
		}
	}

	private boolean isSixLength(List<String> numbers) {
		return numbers.size() == LOTTO_SIZE;
	}

	private void validateIsDigit(List<String> numbers) {
		if (!isDigit(numbers)) {
			NumberFormatExceptionMessage.NUMBERS_ONLY.throwException();
		}
	}

	private boolean isDigit(List<String> numbers) {
		return numbers.stream()
				.allMatch(number -> number.chars().allMatch(Character::isDigit));
	}

	private List<String> convertStringToList(String numbers) {
		return List.of(numbers.split(","));
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != LOTTO_SIZE) {
			IllegalArgumentExceptionMessage.LOTTO_WRONG_FORMAT.throwException();
		}
	}

	private void validateDuplicateNumber(List<Integer> numbers) {
		if (numbers.size() != numbers.stream().distinct().count()) {
			IllegalArgumentExceptionMessage.LOTTO_NUMBER_DUPLICATE.throwException();
		}
	}

	private void validateIsBetweenLottoRange(List<Integer> numbers) {
		if (!isBetweenLottoRange(numbers)) {
			IllegalArgumentExceptionMessage.LOTTO_OUT_OF_RANGE.throwException();
		}
	}

	private boolean isBetweenLottoRange(List<Integer> numbers) {
		return numbers.stream()
				.allMatch(number -> MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER);
	}
}
