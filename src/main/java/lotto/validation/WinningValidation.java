package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.system.Constant.LOTTO_LENGTH;
import static lotto.system.Constant.LOTTO_START_NUMBER;
import static lotto.system.Constant.LOTTO_END_NUMBER;
import static lotto.system.ExceptionMessage.WINNING_VALIDATION_ERROR_MESSAGE;

public class WinningValidation {
	public static void isWinningCorrect(List<Integer> winning) {
		isLengthCorrect(winning);
		isInRangeAndDuplicate(winning);
	}
	
	private static void isLengthCorrect(List<Integer> winning) {
		if (winning.size() != LOTTO_LENGTH.getconstant()) {
			throw new IllegalArgumentException(WINNING_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}
	
	private static void isInRangeAndDuplicate(List<Integer> winning) {
		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		for (int number : winning) {
			checkRange(number);
			checkDuplicate(number, uniqueNumbers);
		}
	}
	
	private static void checkRange(int n) {
		if (n < LOTTO_START_NUMBER.getconstant() || n > LOTTO_END_NUMBER.getconstant()) {
			throw new IllegalArgumentException(WINNING_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}
	
	private static void checkDuplicate(int n, Set<Integer> uniqueNumbers) {
		if (!uniqueNumbers.add(n)) {
			throw new IllegalArgumentException(WINNING_VALIDATION_ERROR_MESSAGE.getMessage());
		}
	}
	
	public static void isBonusCorrect(int bonus, List<Integer> winning) {
		checkRange(bonus);
		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		uniqueNumbers.addAll(winning);
		checkDuplicate(bonus, uniqueNumbers);
	}
}