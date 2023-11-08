package domain;

import java.util.List;
import java.util.stream.Collectors;

import exception.IllegalArgumentExceptionMessage;
import exception.NumberFormatExceptionMessage;

public class Lotto {
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

	private void validateListStringParameter(List<String> parsedNumbers) {
		validateIsDigit(parsedNumbers);
		validateIsSixLength(parsedNumbers);
	}

	private void validateListIntegerParameter(List<Integer> validatedAndParsedNumbers) {
		validateIsBetweenLottoRange(validatedAndParsedNumbers);
		validateDuplicateNumber(validatedAndParsedNumbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
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
		return numbers.size() == 6;
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

	public String removeSpacesBetweenNumbersAndCommas(String numbers) {
		return numbers.replace(" ", "");
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
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
				.allMatch(number -> 1 <= number && number <= 45);
	}

	public String getLottoNumbersAsString() {
		return this.numbers.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(", "));
	}
}
