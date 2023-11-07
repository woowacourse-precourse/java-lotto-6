package lotto.domain.validation.validator;

import static lotto.domain.validation.ExceptionMessage.EXCEPTION_MESSAGE_PREFIX;
import static lotto.domain.validation.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;

public class Validator {

    public boolean isInputInteger(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(EXCEPTION_MESSAGE_PREFIX.getMessage() + NUMBER_FORMAT_EXCEPTION.getMessage());
            return false;
        }
    }

    public void isPurchaseAmountPositive(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void isPurchaseAmountDividedUp(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
