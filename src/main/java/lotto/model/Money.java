package lotto.model;

import lotto.constant.ErrorMessage;

public class Money {
    int money;

    Money(int money) {
        divideByThousand(money);
        isOverThousand(money);
        this.money = money;
    }

    private void divideByThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage
                    .MONEY_ERROR_MESSAGE.getErrorMessage());
        }
    }

    private void isOverThousand(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ErrorMessage
                    .NOT_ENOUGH_MONEY_ERROR_MESSAGE.getErrorMessage());
        }
    }
}
