package lotto.validation;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ErrorValidation {
	// 전체에 적용
	private static int validateInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_IS_NUMBER.getMessage());
		}
		return Integer.parseInt(input);
	}
	
	private static void validateNumberRange(int number) {
		if (number < 1 || number > 45) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_RANGE.getMessage());
		}
	}

	// 당첨 번호
	public static void validateWinningNumbersFormat(String input) {
		validateCommaFormat(input);
		String[] splitInput = input.split(",");
		Arrays.stream(splitInput).forEach(ErrorValidation::validateInteger);
	}

	private static void validateCommaFormat(String input) {
		if (input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_WINNING_CONTAINS_COMMA.getMessage());
		}
	}

	public static void validateComma(String inputNumbers) {
		if (!Pattern.matches("^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$", inputNumbers)) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateWinningNumbers(List<Integer> winningNumbers) {
		winningNumbers.forEach(ErrorValidation::validateNumberRange);
		validateWinningNumbersSize(winningNumbers);
		validateDuplicateNumber(winningNumbers);
	}

	private static void validateWinningNumbersSize(List<Integer> winningNumbers) {
		if (winningNumbers.size() != 6) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_SIZE.getMessage());
		}
	}

	private static void validateDuplicateNumber(List<Integer> numbers) {
		if (numbers.size() != numbers.stream().distinct().count()) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_DUPLICATION.getMessage());
		}
	}

	// 보너스 점수
	public static void validateBonus(String input, List<Integer> winningNumbers) {
		int bonus = validateInteger(input);
		validateDuplicateBonus(winningNumbers, bonus);
		validateNumberRange(bonus);
	}

	private static void validateDuplicateBonus(List<Integer> winningNumbers, int bonus) {
		if (winningNumbers.contains(bonus)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_RANGE_DUPLICATION.getMessage());
		}
	}

	// 구입 금액
	public static void validatePurchase(String input) {
		int purchase = validateInteger(input);
		validatePurchaseLimit(purchase);
		validatePurchase1000(purchase);
	}

	private static void validatePurchaseLimit(int purchase) {
		if (purchase < 1000 || purchase > 100000) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_LIMIT.getMessage());
		}
	}

	private static void validatePurchase1000(int purchase) {
		if (purchase % 1000 != 0) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_1000.getMessage());
		}
	}
}
