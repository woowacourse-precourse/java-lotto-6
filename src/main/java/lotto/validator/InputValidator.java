package lotto.validator;

import lotto.Exception.InputErrorMessage;

public class InputValidator {
    private final static int PRICE = 1000;

    public void validateMoney(int money) {
        int remainder = money % PRICE;

        if (remainder != 0) {
            throw new IllegalArgumentException(
                    InputErrorMessage.INVALID_UNIT.getValue());
        }
    }
}
