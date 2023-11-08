package lotto.view.input.validator;

import lotto.exception.input.EmptyInputException;

import java.util.Arrays;

import static lotto.constant.LottoSymbol.LOTTO_SEPARATOR;
import static lotto.view.message.ValidationErrorMessage.*;

public class WinningNumberValidator {
    public void validate(String userInput) {
        validateNotEmpty(userInput);
        validateSeparator(userInput);
        validateIntegers(userInput);
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new EmptyInputException(INPUT_EMPTY.getMessage());
        }
    }

    public void validateSeparator(String userInput) {
        try {
            Arrays.stream(userInput.split(LOTTO_SEPARATOR.getValue()));
        } catch (Exception e) {
            throw new NumberFormatException(INPUT_WRONG_SEPARATOR.getMessage());
        }
    }

    public void validateIntegers(String userInput) {
        String separator = LOTTO_SEPARATOR.getValue();
        String regex = "^-?\\d+(" + separator + "-?\\d+)*$";
        if (!userInput.matches(regex)) {
            throw new NumberFormatException(INPUT_NOT_INTEGER.getMessage());
        }
    }

}
