package lotto.validator;

import static lotto.constant.Constant.MAX_PRICE;
import static lotto.constant.Constant.UNIT;
import static lotto.constant.Constant.ZERO;
import static lotto.exception.ExceptionMessage.DIFFERENT_FORMAT_EXCEPTION_MESSAGE;
import static lotto.exception.ExceptionMessage.MAX_PRICE_MESSAGE;
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
        return price >= UNIT && price % UNIT==ZERO;
    }

    public void validateMaxPrice(String input) {
        if (!underMaxPrice(input)) {
            throw new LottoApplicationException(MAX_PRICE_MESSAGE);
        }
    }

    public boolean underMaxPrice(String input){
        return input.length() < 11 && convertPrice(input) < MAX_PRICE;
    }

    private Integer convertPrice(String input) {
        return Integer.parseInt(input);
    }

}
