package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.LottoInformation.NUMBER_OF_NUMBERS;
import static lotto.util.LottoInformation.MIN_NUMBER;
import static lotto.util.LottoInformation.MAX_NUMBER;

public class WinningNumbersValidator {
    public void validateWinningNumbers(List<String> numbers) {
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

    private boolean isNumeric(List<String> numbers) {
        for (String numberAsText : numbers) {
            try {
                Integer.parseInt(numberAsText);
            } catch (NumberFormatException e)
            {
                return false;
            }
        }
        return true;
    }

    private boolean isSixNumbers(List<String> numbers) {
        return numbers.size() == NUMBER_OF_NUMBERS;
    }

    private boolean isDuplicateNumbers(List<String> numbers) {
        List<String> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        return distinctNumbers.size() != numbers.size();
    }

    private boolean isWithinRange(List<String> numbers) {
        for (String numberAsText : numbers) {
            int number = Integer.parseInt(numberAsText);
            if (number > MAX_NUMBER || number < MIN_NUMBER) {
                return false;
            }
        }
        return true;
    }
}
