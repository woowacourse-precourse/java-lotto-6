package lotto.validator.input;

import com.sun.jdi.request.DuplicateRequestException;
import lotto.exception.input.EmptyInputException;
import lotto.exception.input.NumberFormatException;

import java.util.List;

import static lotto.view.message.ValidationErrorMessage.*;

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
            throw new EmptyInputException(INPUT_EMPTY.getMessage());
        }
    }

    private void validateIntegerFormat(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_NOT_INTEGER.getMessage());
        }
    }

    private int parseInteger(String userInput) {
        return Integer.parseInt(userInput);
    }

    private void validateDuplicationWithWinningNumbers(int validatedNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(validatedNumber)) {
            throw new DuplicateRequestException(INPUT_DUPLICATE_WITH_WINNING.getMessage());
        }
    }
}
