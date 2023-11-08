package lotto.model;

import lotto.view.OutputView;
import lotto.view.constant.ErrorMessage;

public class Money {
    private final int value;
    public Money(int value) {
        validationMoney(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validationMoney(int value) {
        checkIsPositive(value);
        checkMultipleOf1000(value);
    }
    private static void checkIsPositive(int pay) {
        if (pay <= 0) {
            OutputView.printError(ErrorMessage.PAY_IS_NOT_POSITIVE.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.INPUT.getMessage());
        }
    }
    private static void checkMultipleOf1000(int pay) {
        if (pay % 1000 != 0) {
            OutputView.printError(ErrorMessage.PAY_NOT_MULTIPLE_OF_1000.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.INPUT.getMessage());
        }
    }
}
