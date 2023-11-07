package lotto.utility;

import static lotto.constant.LottoConstant.*;
import static lotto.exception.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;

public class InputValidation {
	public static long validatePrice(String input) throws IllegalArgumentException {
		try {
			long price = Long.parseLong(input.trim());
			validatePriceDivision(price);
			return price;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getMessage());
		}
	}

	private static void validatePriceDivision(long price) throws IllegalArgumentException {
		if (price % LOTTO_PRICE.getValue() != 0) {
			throw new IllegalArgumentException(PRICE_ERROR.getMessage());
		}
	}

	public static List<Integer> validateWinningNumbers(List<String> input) throws IllegalArgumentException {
		validatePickCount(input.size());

		List<Integer> numbers = new ArrayList<>();
		try {
			for (String number : input) {
				numbers.add(Integer.valueOf(number.trim()));
			}
			return numbers;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getMessage());
		}
	}

	private static void validatePickCount(int pickCount) throws IllegalArgumentException {
		if (pickCount != PICK_COUNT.getValue()) {
			throw new IllegalArgumentException(INPUT_COUNT_ERROR.getMessage());
		}
	}

	public static int validateBonusNumber(Lotto winningLotto, String input) throws IllegalArgumentException {
		try {
			int bonusNumber = Integer.parseInt(input.trim());
			validateRange(bonusNumber);
			if (winningLotto.contains(bonusNumber)) {
				throw new IllegalArgumentException(DUPLICATED_ERROR.getMessage());
			}
			return bonusNumber;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getMessage());
		}
	}

	private static void validateRange(int bonusNumber) throws IllegalArgumentException {
		if (bonusNumber < MIN_LOTTO_NUMBER.getValue() || MAX_LOTTO_NUMBER.getValue() < bonusNumber) {
			throw new IllegalArgumentException(RANGE_ERROR.getMessage());
		}
	}
}
