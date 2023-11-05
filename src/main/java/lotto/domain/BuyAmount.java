package lotto.domain;

import static lotto.constant.ExceptionMessage.DIVISION_ERROR_MESSAGE;

public class BuyAmount {

    private final long buyAmount;

    public BuyAmount(long buyAmount) {
        validateAbleToDivide(buyAmount);
        this.buyAmount = buyAmount;
    }

    public void validateAbleToDivide(long buyAmount) {
        if (buyAmount % 1000 != 0) {
            throw new IllegalArgumentException(DIVISION_ERROR_MESSAGE);
        }
    }

    public int getAbleToBuyCount() {
        return (int) (buyAmount / 1000);
    }
}
