package lotto.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InputValidator {
    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        validateDividedBy1000(purchaseAmount);
        validateAmountLimit(purchaseAmount);
    }

    public static void validateWinningNumbersFormat(String input) {
        validateCommaFormat(input);
        String[] splitInput = input.split(",");
        Arrays.stream(splitInput).forEach(InputValidator::validateInteger);
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        winningNumbers.forEach(InputValidator::validateLottoNumberRange);
        validateWinningNumbersSize(winningNumbers);
        validateDuplicateNumber(winningNumbers);
    }

    private static void validateAmountLimit(int purchaseAmount) {
        if (purchaseAmount > 100000) {
            throw new IllegalArgumentException();
        }

        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDividedBy1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCommaFormat(String input) {
        if(input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLottoNumberRange(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private static void validateDuplicateNumber(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
