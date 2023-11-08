package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.view.ExceptionMessage;

public class LottoValidator {
	private static final int MAX_LOTTO_SIZE = 6;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final String SIZE_EXCEPTION = "[ERROR] 로또 번호의 개수는 6개 입니다.";
	private static final String OVERLAP_EXCEPTION = "[ERROR] 로또 번호는 서로 다른 6개의 숫자입니다.";
	private static final String OUT_OF_RANGE_EXCEPTION = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

	private LottoValidator() {
	}

	public static void validateLotto(List<Integer> numbers) {
		validateSize(numbers);
		validateOverlap(numbers);
		validateRange(numbers);
	}

	public static void validateSize(List<Integer> numbers) {
		if (numbers.size() != MAX_LOTTO_SIZE) {
			ExceptionMessage.sizeException();
			throw new IllegalArgumentException(SIZE_EXCEPTION);
		}
	}

	public static void validateOverlap(List<Integer> numbers) {
		Set<Integer> overlapCheck = new HashSet<>(numbers);
		if (overlapCheck.size() != MAX_LOTTO_SIZE) {
			ExceptionMessage.overlapException();
			throw new IllegalArgumentException(OVERLAP_EXCEPTION);
		}
	}

	public static void validateRange(List<Integer> numbers) {
		for (int winningNumber : numbers) {
			if (winningNumber < MIN_NUMBER || winningNumber > MAX_NUMBER) {
				ExceptionMessage.rangeException();
				throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
			}
		}
	}
}
