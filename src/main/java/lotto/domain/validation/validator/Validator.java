package lotto.domain.validation.validator;

import static lotto.domain.validation.ExceptionMessage.EXCEPTION_MESSAGE_PREFIX;
import static lotto.domain.validation.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;

public class Validator {

    public boolean isPurchaseAmountInteger(String input){
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            System.out.println(EXCEPTION_MESSAGE_PREFIX.getMessage() + NUMBER_FORMAT_EXCEPTION.getMessage());
            return true;
        }
    }
}
