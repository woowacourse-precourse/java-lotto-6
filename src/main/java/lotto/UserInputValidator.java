package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.enums.LottoError;
import lotto.enums.PriceInputError;

public class UserInputValidator {

	public static int validateInputNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(PriceInputError.INVALID_TYPE_INPUT.getErrorDescription());
		}
	}

	public static List<Integer> validateInputNumbers(String input) {
		List<Integer> validNumbers = new ArrayList<>();
		try {
			String[] inputNumbers = input.split(",");
			for (String num : inputNumbers) {
				validNumbers.add(Integer.parseInt(num.strip()));
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(LottoError.INVALID_INPUT_NUMBER.getErrorDescription());
		}
		return validNumbers;
	}
}
