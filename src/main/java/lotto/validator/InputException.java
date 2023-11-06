package lotto.validator;

import static lotto.constants.MessageConstants.INPUT_DUPLICATION;
import static lotto.constants.MessageConstants.NO_NUMBER;
import static lotto.constants.MessageConstants.NO_THOUSAND_UNITS;
import static lotto.constants.MessageConstants.WRONG_INPUT;
import static lotto.constants.MessageConstants.YES_BLANK;
import static lotto.constants.MessageConstants.YES_EMPTY;

import java.util.List;

public class InputException {

	public static void checkEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(YES_EMPTY);
		}

	}

	public static void checkBlank(String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException(YES_BLANK);
		}

	}

	public static void checkNumber(String input) {
		try {
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NO_NUMBER);
		}
	}

	public static void checkOutOfNumber(String input) {
		try {
			int purchaseAmount = Integer.parseInt(input);
			if (purchaseAmount % 1000 != 0 || purchaseAmount == 0) {
				throw new IllegalArgumentException(NO_THOUSAND_UNITS);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NO_NUMBER);

		}

	}

	public static void checkComma(String input) {
		if (input.startsWith(",") || input.endsWith(",")) {
			throw new IllegalArgumentException(WRONG_INPUT);
		}
	}

	public static void checkDuplication(int bonusNumber, List<Integer> winningNumber) {
		if (winningNumber.contains(bonusNumber)) {
			throw new IllegalArgumentException(INPUT_DUPLICATION);
		}
	}

}
