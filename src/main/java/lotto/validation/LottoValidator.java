package lotto.validation;

import static lotto.constant.GameRule.LOTTO_SIZE;
import static lotto.constant.GameRule.LOTTO_MIN_NUMBER;
import static lotto.constant.GameRule.LOTTO_MAX_NUMBER;
import static lotto.exception.ExceptionMessage.LOTTO_DUPLICATED_ERROR;
import static lotto.exception.ExceptionMessage.LOTTO_INVALID_SIZE;
import static lotto.exception.ExceptionMessage.LOTTO_OUT_OF_RANGE_ERROR;

import java.util.List;

import lotto.exception.LottoException;

public class LottoValidator {
	public static void canBeLotto(List<Integer> numbers) {
		LottoValidator.validateSize(numbers);
		LottoValidator.validateDuplication(numbers);
		LottoValidator.validateRange(numbers);
	}

	public static void validateSize(List<Integer> numbers) {
		if (numbers.size() != LOTTO_SIZE) {
			throw new LottoException(LOTTO_INVALID_SIZE.getMessage());
		}
	}

	public static void validateDuplication(List<Integer> numbers) {
		if (isDuplicated(numbers)) {
			throw new LottoException(LOTTO_DUPLICATED_ERROR.getMessage());
		}
	}

	public static void validateRange(List<Integer> numbers) {
		if (isNumbersNotInRange(numbers)) {
			throw new LottoException(LOTTO_OUT_OF_RANGE_ERROR.getMessage());
		}
	}

	public static void validateRange(int number) {
		if (isNumberNotInRange(number)) {
			throw new LottoException(LOTTO_OUT_OF_RANGE_ERROR.getMessage());
		}
	}

	private static boolean isDuplicated(List<Integer> numbers) {
		return numbers.stream()
			.distinct()
			.count() != numbers.size();
	}

	private static boolean isNumbersNotInRange(List<Integer> numbers) {
		return numbers.stream()
			.anyMatch(LottoValidator::isNumberNotInRange);
	}

	private static boolean isNumberNotInRange(int number) {
		return number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER;
	}
}
