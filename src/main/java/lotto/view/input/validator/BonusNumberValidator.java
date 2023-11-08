package lotto.view.input.validator;

import lotto.exception.input.DuplicatedNumberException;
import lotto.exception.input.EmptyInputException;
import lotto.exception.input.NumberFormatException;

import java.util.List;

import static lotto.view.input.parser.numberParser.parseInteger;
import static lotto.view.message.ValidationErrorMessage.*;

public class BonusNumberValidator {

    public void validate(String userInput, List<Integer> winningNumbers) {
        validateNotEmpty(userInput);
        validateIntegerFormat(userInput);
        validateDuplicationWithWinningNumbers(userInput, winningNumbers);
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

    private void validateDuplicationWithWinningNumbers(String userInput, List<Integer> winningNumbers) {
        if (winningNumbers.contains(parseInteger(userInput))) {
            throw new DuplicatedNumberException(INPUT_DUPLICATE_WITH_WINNING.getMessage());
        }
    }
}
