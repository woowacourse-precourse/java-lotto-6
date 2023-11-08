package lotto.global.util;

import lotto.global.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Validator {
    static void validatePrice(String price) {
        try {
            int processedPrice = Integer.parseInt(price);
            validateMismatchPrice(processedPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_NOT_INTEGER.getMessage());
        }
    }

    static void validateNumbers(String numbers) {
        validateIsBlankNumbers(numbers);
        validateNotContainSymbolNumbers(numbers);
        validateInvalidSymbolPositionNumbers(numbers);
        validateValidLengthNumbers(numbers);
        validateValidTypeAndRangeNumbers(numbers);
        validateDuplicateNumbers(numbers);
    }

    static void validateBonusNumber(String bonusNumber) {
        try {
            int processedBonusNumber = Integer.parseInt(bonusNumber);
            validateMismatchBonusNumber(processedBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_INTEGER.getMessage());
        }
    }

    private static void validateMismatchPrice(int processedPrice) {
        if (processedPrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_MISMATCH.getMessage());
        }
    }

    private static void validateIsBlankNumbers(String numbers) {
        if (numbers.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_BLANK.getMessage());
        }
    }

    private static void validateNotContainSymbolNumbers(String numbers) {
        if (!numbers.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_CONTAIN_SYMBOL.getMessage());
        }
    }

    private static void validateInvalidSymbolPositionNumbers(String numbers) {
        if (numbers.startsWith(",") || numbers.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_INVALID_SYMBOL_POSITION.getMessage());
        }
    }

    private static void validateValidLengthNumbers(String numbers) {
        String[] processedNumbers = numbers.split(",");
        if (processedNumbers.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_INVALID_COUNT.getMessage());
        }
    }

    private static void validateValidTypeAndRangeNumbers(String numbers) {
        String[] processedNumbers = numbers.split(",");
        Arrays.stream(processedNumbers)
                .forEach(number -> {
                    try {
                        int processedNumber = Integer.parseInt(number);
                        if (processedNumber < 1 || processedNumber > 45) {
                            throw new IllegalArgumentException(ErrorMessage.NUMBER_INVALID_RANGE.getMessage());
                        }
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_INTEGER.getMessage());
                    }
                });
    }

    private static void validateDuplicateNumbers(String numbers) {
        String[] processedNumbers = numbers.split(",");
        List<String> seen = new ArrayList<>();
        Arrays.stream(processedNumbers)
                .forEach(number -> {
                    if (seen.contains(number)) {
                        throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE.getMessage());
                    }
                    seen.add(number);
                });
    }

    private static void validateMismatchBonusNumber(int processedBonusNumber) {
        if (processedBonusNumber < 1 || processedBonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_INVALID_RANGE.getMessage());
        }
    }
}
