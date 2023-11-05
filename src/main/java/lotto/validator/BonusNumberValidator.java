package lotto.validator;

import java.util.List;

public class BonusNumberValidator {

    public int validateAndParse(String userInput, List<Integer> winningNumbers) {
        validateNotEmpty(userInput);
        validateIntegerFormat(userInput);
        int number = parseInteger(userInput);
        validateDuplicationWithWinningNumbers(number, winningNumbers);
        return number;
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIntegerFormat(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private int parseInteger(String userInput) {
        return Integer.parseInt(userInput);
    }

    private void validateDuplicationWithWinningNumbers(int validatedNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(validatedNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
