package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.util.ErrorMessage.NOT_NUMBER_INPUTTED;
import static lotto.util.ErrorMessage.TOO_LARGE_NUMBER;

public class InputValidator extends Validator {
    private static final int MEMORY_SIZE_LIMIT = 2100000000;
    private static final String NUMBER_SPLITTER = ",";

    public int parseValidatedInt(String numberMessage) {
        int resultNumber = 0;
        try {
            resultNumber = Integer.parseInt(numberMessage);
            validateMemorySizeLimit(resultNumber);
        } catch (NumberFormatException e) {
            throwIllegalArgumentException(NOT_NUMBER_INPUTTED.getMessage(), e);
        }
        return resultNumber;
    }

    private void validateMemorySizeLimit(int number) {
        if (number >= MEMORY_SIZE_LIMIT) {
            throwIllegalArgumentException(TOO_LARGE_NUMBER.getMessage());
        }
    }

    public List<Integer> parseValidatedNumbers(String numbersMessage) {
        List<Integer> validatedNumbers = new ArrayList<>();
        Arrays.stream(numbersMessage.split(NUMBER_SPLITTER))
                .map(String::trim)
                .mapToInt(this::parseValidatedInt)
                .forEach(validatedNumbers::add);

        return validatedNumbers;
    }
}