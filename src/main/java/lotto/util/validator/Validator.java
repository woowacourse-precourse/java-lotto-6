package lotto.util.validator;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {

	public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

	private Validator() {
		throw new AssertionError();
	}

	public static void validateNumberFormat(String inputValue, String message) {
		if (!NUMBER_PATTERN.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validateIsEmpty(String inputValue, String message) {
		if (isStringEmpty(inputValue)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validateStrArrLength(String[] inputValue, int length, String message) {
		if (inputValue.length != length) {
			throw new IllegalArgumentException(message);
		}
	}

	private static boolean isStringEmpty(String str) {
		return str == null || str.isBlank();
	}

	public static void validateSize(List<Integer> numbers, int size, String message) {
		if (numbers.size() != size) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validateDuplicateNumber(List<Integer> numbers, String message) {
		if (numbers.stream().distinct().count() != numbers.size()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validateNumbersOutOfRange(List<Integer> numbers, int[] ranges, String message) {
		if (numbers.stream().anyMatch(number -> isNumberOutOfRange(number, ranges))) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validateNumberOutOfRange(int number, int[] ranges, String message) {
		if (isNumberOutOfRange(number, ranges)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void validateNumberInNumbers(List<Integer> numbers, int number, String message) {
		if (numbers.contains(number)) {
			throw new IllegalArgumentException(message);
		}
	}

	private static boolean isNumberOutOfRange(int number, int[] ranges) {
		return number > Math.max(ranges[0], ranges[1]) || number < Math.min(ranges[0], ranges[1]);
	}
}
