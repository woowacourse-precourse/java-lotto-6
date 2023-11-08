package lotto.model;

import lotto.view.OutputView;
import lotto.view.constant.ErrorMessage;

import static java.lang.Integer.parseInt;

public class Money {
    private final int value;
    public Money(String value) {
        validationMoney(value);
        this.value = parseInt(value);
    }

    public int getValue() {
        return value;
    }

    private void validationMoney(String value) {
        validateIsNumber(value);
        validateIsPositive(parseInt(value));
        validateMultipleOf1000(parseInt(value));
    }

    private void validateIsNumber(String money) {
        try {
            parseInt(money);
        } catch (NumberFormatException error) {
            OutputView.printError(ErrorMessage.IS_NOT_NUMBER.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage()+ErrorMessage.INPUT.getMessage());
        }
    }

    private static void validateIsPositive(int pay) {
        if (pay <= 0) {
            OutputView.printError(ErrorMessage.PAY_IS_NOT_POSITIVE.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.INPUT.getMessage());
        }
    }

    private static void validateMultipleOf1000(int pay) {
        if (pay % 1000 != 0) {
            OutputView.printError(ErrorMessage.PAY_NOT_MULTIPLE_OF_1000.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.INPUT.getMessage());
        }
    }
}
