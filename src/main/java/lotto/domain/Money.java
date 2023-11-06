package lotto.domain;

import lotto.utils.Constants;
import lotto.utils.ErrorMessage;

public class Money {
    private int money;

    public Money(int inputMoney) {
        validateInputMoney(inputMoney);
        this.money = inputMoney;
    }

    private void validateInputMoney(int inputMoney) {
        validateMinAmount(inputMoney);
        validateMaxAmount(inputMoney);
        validateDivisible(inputMoney);
    }

    private void validateMinAmount(int inputMoney) {
        if (inputMoney < Constants.MINIMUM_INPUT_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_BELOW_MIN_AMOUNT_ERROR.getMessage());
        }
    }

    private void validateMaxAmount(int inputMoney) {
        if (inputMoney > Constants.MAXIMUM_INPUT_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_ABOVE_MAX_AMOUNT_ERROR.getMessage());
        }
    }

    private void validateDivisible(int inputMoney) {
        if (inputMoney % Constants.DIVISION_UNIT_FOR_INPUT_MONEY != 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_NOT_DIVISIBLE_ERROR.getMessage());
        }
    }

    public int calculateTicketCount() {
        return money / Constants.DIVISION_UNIT_FOR_INPUT_MONEY;
    }

    public int getMoney() {
        return money;
    }
}