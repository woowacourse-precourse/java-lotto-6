package lotto.view;

import lotto.exception.DuplicateInputException;
import lotto.exception.HasNotCommaException;
import lotto.exception.InvalidInputException;

import java.util.List;

import static lotto.constants.DomainConstants.*;
import static lotto.constants.ExceptionConstants.*;
import static lotto.constants.InputConstants.NUMERIC;
import static lotto.constants.InputConstants.SPLIT_STANDARD;

public class InputValidator {
    public void validateInputMoney(String inputMoney) {
        if (!isNumeric(inputMoney)) {
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean isNumeric(String inputMoney) {
        return inputMoney.matches(NUMERIC);
    }

    public void validateConvertInputToList(List<Integer> inputWinningNumbers) {
        if (isValidSize(inputWinningNumbers)) {
            throw new InvalidInputException(SIZE_NOT_VALID_MESSAGE);
        }

        if (hasDuplicatedNumbers(inputWinningNumbers)) {
            throw new DuplicateInputException();
        }
        if (isValidRange(inputWinningNumbers)) {
            throw new InvalidInputException(INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }

    private boolean isValidRange(List<Integer> inputWinningNumbers) {
        return inputWinningNumbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);
    }

    private boolean hasDuplicatedNumbers(List<Integer> inputWinningNumbers) {
        return inputWinningNumbers.stream().distinct().count() != REQUIRED_NUMBER_COUNT;
    }

    private boolean isValidSize(List<Integer> inputWinningNumbers) {
        return inputWinningNumbers.size() != REQUIRED_NUMBER_COUNT;
    }

    public void validateInputWinningNumbersHasComma(String inputWinningNumbers) {
        if (!inputWinningNumbers.contains(SPLIT_STANDARD)) {
            throw new HasNotCommaException(HAS_NOT_COMMA_MESSAGE);
        }
    }
}
