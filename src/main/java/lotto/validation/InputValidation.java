package lotto.validation;

import java.util.Arrays;
import java.util.List;
import lotto.utils.constants.ExceptionMessage;

public class InputValidation {

    private static final String COMMA = ",";

    public static void validateIsBlank(String purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_BLANK.getMessage());
        }
    }

    public static int validateInputPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_NOT_THOUSAND.getMessage());
        }
        return purchaseAmount;
    }

    public static String validateInputString(String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_STRING_NOT_NUMBER.getMessage());
        }
        return purchaseAmount;
    }

    public static List<Integer> validateInputWinningNumber(String winningNum) {
        List<String> numberStrings = Arrays.asList(winningNum.split(COMMA));
        validateMinimumSize(numberStrings);
        List<Integer> numberList = parseToIntegers(numberStrings);
        validateNoDuplicates(numberList);
        validateNumberRange(numberList);
        validateSixNumbers(numberList);
        return numberList;
    }

    public static void validateMinimumSize(List<String> numberStrings) {
        if (numberStrings.size() < 6) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_LOTTO_NUMBER.getMessage());
        }
    }

    public static List<Integer> parseToIntegers(List<String> numberStrings) {
        return numberStrings.stream()
            .map(Integer::parseInt)
            .toList();
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_LOTTO_DUPULICATED_NUMBER.getMessage());
        }
    }

    public static boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() < numbers.size();
    }

    public static void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNIG_LOTTO_INCLUDED_VALUE_NUMBER.getMessage());
        }
    }

    public static void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.WINNIG_LOTTO_SIX_VALUE_NUMBER.getMessage());
        }
    }
}
