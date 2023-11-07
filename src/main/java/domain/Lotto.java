package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		validateDuplicateNumber(numbers);
		validateIsBetweenLottoRange(numbers);
		validateDuplicateNumber(numbers);
		this.numbers = numbers;
	}

	public Lotto(String numbers) {
		List<String> parsedNumbers = convertStringToList(removeSpacesBetweenNumbersAndCommas(numbers));
		validateIsDigit(parsedNumbers);
		validateIsSixLength(parsedNumbers);
		List<Integer> validatedAndParsedNumbers = convertStringListToIntegerList(parsedNumbers);
		validateIsBetweenLottoRange(validatedAndParsedNumbers);
		validateDuplicateNumber(validatedAndParsedNumbers);
		this.numbers = validatedAndParsedNumbers;
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
			throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표로 구분해서 6개를 입력하세요");
		}
	}

	private boolean isSixLength(List<String> numbers) {
		return numbers.size() == 6;
	}

	private void validateIsDigit(List<String> numbers) {
		if (!isDigit(numbers)) {
			throw new NumberFormatException("[ERROR] 숫자만 입력하세요");
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
			throw new IllegalArgumentException("[ERROR] 로또번호는 6개를 쉼표로 구분해서 입력해주세요");
		}
	}

	private void validateDuplicateNumber(List<Integer> numbers) {
		if (numbers.size() != numbers.stream().distinct().count()) {
			throw new IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력하세요");
		}
	}

	private void validateIsBetweenLottoRange(List<Integer> numbers) {
		if (!isBetweenLottoRange(numbers)) {
			throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자로 입력하세요");
		}
	}

	private boolean isBetweenLottoRange(List<Integer> numbers) {
		return numbers.stream()
				.allMatch(number -> 1 <= number && number <= 45);
	}
}
