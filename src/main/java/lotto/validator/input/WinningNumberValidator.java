package lotto.validator.input;

import lotto.exception.input.EmptyInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.message.ValidationErrorMessage.INPUT_EMPTY;
import static lotto.view.message.ValidationErrorMessage.INPUT_WRONG_SEPARATOR;

public class WinningNumberValidator {
    public List<Integer> validateAndParse(String userInput) {
        validateNotEmpty(userInput);
        return validateAndSeparateIntegers(userInput);
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new EmptyInputException(INPUT_EMPTY.getMessage());
        }
    }

    public static List<Integer> validateAndSeparateIntegers(String userInput) {
        try {
            return Arrays.stream(userInput.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NumberFormatException(INPUT_WRONG_SEPARATOR.getMessage());
        }
    }
}
