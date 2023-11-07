package lotto.model;

import lotto.util.ErrorMessage;

public class Coin {

    private final int UNIT = 1000;
    private final int amount;
    public Coin(int amount) {
        validateAmount(amount);
        validateAmountUnit(amount);
        this.amount = amount;
    }

    public int getCount() {
        return this.amount / UNIT;
    }

    // 구입 금액이 1000원을 넘는지 검증
    private void validateAmount(int amount) {
        if(amount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAYMENT_AMOUNT.getMessage());
        }
    }

    // 구입 금액이 1000으로 나누어 떨어지는지 검증
    private void validateAmountUnit(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAYMENT_AMOUNT.getMessage());
        }
    }
}
