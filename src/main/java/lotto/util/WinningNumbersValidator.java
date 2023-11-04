package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.LottoInformation.NUMBER_OF_NUMBERS;
import static lotto.util.LottoInformation.MIN_NUMBER;
import static lotto.util.LottoInformation.MAX_NUMBER;

public class WinningNumbersValidator {
    public static void validateWinningNumbers(List<String> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(NumberErrorMessage.NUMBER_IN_EMPTY.getMessage());
        }

        if (!isNumeric(numbers)) {
            throw new IllegalArgumentException(NumberErrorMessage.NOT_A_NUMBER.getMessage());
        }

        if (!isSixNumbers(numbers)) {
            throw new IllegalArgumentException(NumberErrorMessage.NUMBER_IS_NOT_SIX.getMessage());
        }

        if (isDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(NumberErrorMessage.DUPLICATE_NUMBERS.getMessage());
        }

        if (!isWithinRange(numbers)) {
            throw new IllegalArgumentException(NumberErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    private static boolean isNumeric(List<String> numbers) {
        for (String numberAsString : numbers) {
            try {
                Integer.parseInt(numberAsString);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSixNumbers(List<String> numbers) {
        return numbers.size() == NUMBER_OF_NUMBERS;
    }

    private static boolean isDuplicateNumbers(List<String> numbers) {
        List<String> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        return distinctNumbers.size() != numbers.size();
    }

    private static boolean isWithinRange(List<String> numbers) {
        for (String numberAsString : numbers) {
            int number = Integer.parseInt(numberAsString);
            if (number > MAX_NUMBER || number < MIN_NUMBER) {
                return false;
            }
        }
        return true;
    }
}
