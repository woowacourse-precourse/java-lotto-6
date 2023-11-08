package lotto.view;

import java.util.Arrays;

import static lotto.message.ErrorMessage.*;

public class InputValidator {

    public void validateWholeNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_WHOLE_NUMBER.getMessage());
        }
    }

    public void validateWholeNumbers(String numbers) {
        Arrays.stream(numbers.split(","))
                .forEach(this::validateWholeNumber);
    }
}
