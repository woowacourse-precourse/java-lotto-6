package lotto.validation;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ErrorValidation {
	public static void validateWinningNumbersFormat(String input) {
        validateCommaFormat(input);
        String[] splitInput = input.split(",");
        Arrays.stream(splitInput).forEach(ErrorValidation::validateInteger);
    }
	
	private static void validateCommaFormat(String input) {
        if(input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_WINNING_CONTAINS_COMMA.getMessage());
        }
    }
	
	public static void validateComma(String inputNumbers) {
		if (!Pattern.matches("^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$", inputNumbers)) {
            throw new IllegalArgumentException();
        }
	}
	
	private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_NUMBER.getMessage());
        }
    }
	
	public static void validateWinningNumbers(List<Integer> winningNumbers) {
        winningNumbers.forEach(ErrorValidation::validateLottoNumberRange);
        validateWinningNumbersSize(winningNumbers);
        validateDuplicateNumber(winningNumbers);
    }
	
	private static void validateLottoNumberRange(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_RANGE.getMessage());
        }
    }
	
	private static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_SIZE.getMessage());
        }
    }
	
	private static void validateDuplicateNumber(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_DUPLICATION.getMessage());
        }
    }
	
	
	
	//
	public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateInteger(input);
        int bonusNumber = Integer.parseInt(input);
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);
        validateLottoNumberRange(bonusNumber);
    }
	
	private static void validateDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_RANGE_DUPLICATION.getMessage());
        }
    }
	
	//
	public static void validatePurchaseAmount(String input) {
        validateInteger(input);
        int purchaseAmount = Integer.parseInt(input);
        validateAmountLimit(purchaseAmount);
        validateDividedBy1000(purchaseAmount);
    }
	
	private static void validateAmountLimit(int purchaseAmount) {
        if (purchaseAmount > 100000 || purchaseAmount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_LIMIT.getMessage());
        }
    }
	
	private static void validateDividedBy1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASE_1000.getMessage());
        }
    }

}
