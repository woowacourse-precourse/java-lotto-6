package lotto.model;

import static lotto.Constraints.MAX_NUMBER;
import static lotto.Constraints.MIN_NUMBER;
import static lotto.model.enums.ErrorMessage.NOT_CORRECT_INPUT_MESSAGE;
import static lotto.model.enums.ErrorMessage.OUT_OF_RANGE_NUMBER_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public List<Integer> validateInput(List<String> input) {
        List<Integer> inputNumbers = validateInteger(input);
        validateInRangeNumber(inputNumbers);
        return inputNumbers;
    }

    private List<Integer> validateInteger(List<String> numbers) {
        List<Integer> integerNumbers = new ArrayList<>();
        numbers.forEach(number -> {
            try {
                integerNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NOT_CORRECT_INPUT_MESSAGE.getMessage());
            }
        });
        return integerNumbers;
    }

    private void validateInRangeNumber(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number > MAX_NUMBER.getValue() || number < MIN_NUMBER.getValue())
                .forEach(number -> {
                    throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());
                });
    }
}