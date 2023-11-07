package lotto.utility;

import static lotto.constant.LottoConstant.*;
import static lotto.exception.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

public class InputValidation {
	public static long validatePrice(String input) {
		try {
			long price = Long.parseLong(input.trim());
			validatePriceDivision(price);
			return price;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getMessage());
		}
	}

	private static void validatePriceDivision(long price) {
		if (price % LOTTO_PRICE.getValue() != 0) {
			throw new IllegalArgumentException(PRICE_ERROR.getMessage());
		}
	}

	public static List<Integer> validateWinningNumbers(List<String> input) {
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

	private static void validatePickCount(int pickCount) {
		if (pickCount != PICK_COUNT.getValue()) {
			throw new IllegalArgumentException(INPUT_COUNT_ERROR.getMessage());
		}
	}

	public static int validateBonusNumber(String input) {
		try {
			return Integer.parseInt(input.trim());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getMessage());
		}
	}
}
