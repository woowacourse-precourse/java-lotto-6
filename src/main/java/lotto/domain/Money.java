package lotto.domain;

import lotto.exception.ExceptionMessage;

public class Money {

    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private final int money;

    public Money(int money){
        validate(money);
        this.money = money;
    }

    private void validate(int inputMoney) {
        validateZero(inputMoney);
        validateThousand(inputMoney);
    }

    private void validateZero(int inputMoney) {
        if (inputMoney == ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.ZERO_MONEY_ERROR);
        }
    }

    private void validateThousand(int inputMoney) {
        if (inputMoney % THOUSAND != ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.DIVIDE_MONEY_ERROR);
        }
    }

    public int getLottoCount() {
        return money / 1000;
    }
}
