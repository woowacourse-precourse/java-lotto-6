package lotto.validator;

import static lotto.exception.ExceptionMessage.DIFFERENT_FORMAT_EXCEPTION_MESSAGE;
import static lotto.exception.ExceptionMessage.NOT_NUMBER_EXCEPTION_MESSAGE;
import static lotto.exception.ExceptionMessage.NULL_POINTER_EXCEPTION_MESSAGE;

import lotto.exception.LottoApplicationException;

public class InputValidator {

    public InputValidator() {
    }

    public void validateNotNull(String input) {
        if (input==null || input.isEmpty()) {
            throw new LottoApplicationException(NULL_POINTER_EXCEPTION_MESSAGE);
        }
    }

    public void validateNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new LottoApplicationException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public void validatePurchasePrice(String input) {
        if (!availDividePrice(input)) {
            throw new LottoApplicationException(DIFFERENT_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private boolean availDividePrice(String input) {
        Integer price = convertPrice(input);
        return price >= 1000 && price % 1000==0;
    }

    private Integer convertPrice(String input) {
        return Integer.parseInt(input);
    }

}
