package lotto.validation;


import java.util.List;
import lotto.constants.ExceptionMessages;

public class InputValidation {


    public void validatePurchaseAmountInput(String input) {
        isExist(input);
        isDigit(input);
        isDivisibleBy1000(input);
    }

    public void isExist(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NONE_INPUT.getMessage());
        }
    }

    public void isDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessages.NONE_DIGIT.getMessage());
        }
    }

    public void isDivisibleBy1000(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessages.NON_MULTIPLE_OF_1000.getMessage());
        }
    }
}
