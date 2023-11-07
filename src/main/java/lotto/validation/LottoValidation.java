package lotto.validation;

import static lotto.system.Constant.LOTTO_END_NUMBER;
import static lotto.system.Constant.LOTTO_LENGTH;
import static lotto.system.Constant.LOTTO_START_NUMBER;
import static lotto.system.ExceptionMessage.LOTTO_VALIDATION_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidation {
	public static void isLottoCorrect(List<Integer> numbers) {
		isBlank(numbers);
		isLengthCorrect(numbers);
		isInRangeAndDuplicate(numbers);
	}
	
	private static void isBlank(List<Integer> numbers) {
		if (numbers.isEmpty()) {
			throw new IllegalArgumentException(LOTTO_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}
	
	private static void isLengthCorrect(List<Integer> numbers) {
		if (numbers.size() != LOTTO_LENGTH.getconstant()) {
			throw new IllegalArgumentException(LOTTO_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}
	
	private static void isInRangeAndDuplicate(List<Integer> numbers) {
		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		for (int number : numbers) {
			checkRange(number);
			checkDuplicate(number, uniqueNumbers);
		}
	}
	
	public static void checkRange(int n) {
		if (n < LOTTO_START_NUMBER.getconstant() || n > LOTTO_END_NUMBER.getconstant()) {
			throw new IllegalArgumentException(LOTTO_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}
	
	public static void checkDuplicate(int n, Set<Integer> uniqueNumbers) {
		if (!uniqueNumbers.add(n)) {
			throw new IllegalArgumentException(LOTTO_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}
}