package lotto.Domain;

import lotto.Util.ErrorMessage;

public class Money {
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int inputMoney) {
        validateZero(inputMoney);
        validateThousandMoney(inputMoney);
    }

    private void validateZero(int inputMoney) {
        if (inputMoney == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_ERROR_MESSAGE);
        }
    }

    private void validateThousandMoney(int inputMoney) {
        if (inputMoney % THOUSAND != ZERO) {
            throw new IllegalArgumentException(ErrorMessage.THOUSAND_ERROR_MESSAGE);
        }
    }

    public int getTicket() {
        return money / THOUSAND;
    }

    public int getMoney() {
        return money;
    }
}
