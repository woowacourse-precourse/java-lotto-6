package lotto.domain;

import static lotto.constant.ExceptionMessage.DIVISION_ERROR_MESSAGE;
import static lotto.constant.LottoConstant.LOTTO_PRICE;

public class BuyAmount {

    private final long buyAmount;

    public BuyAmount(long buyAmount) {
        validateAbleToDivide(buyAmount);
        this.buyAmount = buyAmount;
    }

    public int getAbleToBuyCount() {
        return (int) (buyAmount / LOTTO_PRICE);
    }

    private void validateAbleToDivide(long buyAmount) {
        if (buyAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(DIVISION_ERROR_MESSAGE);
        }
    }


}
