package lotto.global.util;

import lotto.view.ErrorMessages;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
	private InputValidator() {
	}

	public static void validatePrice(String input) {
		validateNumberFormat(input);
		validateDivisiblePrice(Integer.parseInt(input));
	}

	public static void validateNumbers(String input) {
		List<String> numbers = Arrays.stream(input.split(",")).toList();

		if (numbers.size() != Constants.LOTTO_NUMBER_COUNT.value) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_COUNT.message);
		}

		int size = numbers.stream()
						  .map(it -> {
							  validateNumberFormat(it);
							  return Integer.parseInt(it);
						  })
						  .peek(InputValidator::validateNumberRange)
						  .distinct()
						  .toList()
						  .size();

		if (size != Constants.LOTTO_NUMBER_COUNT.value) {
			throw new IllegalArgumentException(ErrorMessages.NUMBER_DUPLICATION.message);
		}
	}

	public static void validateBonusNumber(String input) {
		validateNumberFormat(input);
		validateNumberRange(Integer.parseInt(input));
	}

	private static void validateNumberFormat(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_FORMAT.message);
		}
	}

	private static void validateNumberRange(int number) {
		if (number < Constants.MIN_LOTTO_NUMBER.value || number > Constants.MAX_LOTTO_NUMBER.value) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE.message);
		}
	}

	private static void validateDivisiblePrice(int number) {
		if ((number % Constants.PRICE_UNIT.value) != 0) {
			throw new IllegalArgumentException(ErrorMessages.INDIVISIBLE_PRICE.message);
		}
	}
}