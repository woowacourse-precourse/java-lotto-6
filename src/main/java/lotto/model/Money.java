package lotto.model;

import lotto.util.Message;
import lotto.util.ValidationCheck;

public class Money {
    private static final int UNIT = 1_000;
    private int givenMoney;

    public void inputMoney(String input) {
        Integer inputNumber = inputNumberNumericValidate(input);
        if (inputNumber < 1) {
            throw new IllegalArgumentException(Message.EXCPTION_LESS_THAN_THOUSNAD);
        }
        if (inputNumber % UNIT != 0) {
            throw new IllegalArgumentException(Message.EXCPTION_DIVIDE_INTO_THOUSNAD);
        }
        this.givenMoney = inputNumber;
    }

    private int inputNumberNumericValidate(String input) {
        ValidationCheck validationCheck = new ValidationCheck();
        return validationCheck.checkNumericValidate(input);
    }

    public int countQuantity() {
        return (givenMoney / UNIT);
    }
}
