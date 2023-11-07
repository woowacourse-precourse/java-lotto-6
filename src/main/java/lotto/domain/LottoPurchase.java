package lotto.domain;

import lotto.enums.ExceptionMessage;

public class LottoPurchase {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public LottoPurchase(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int calculateLottoCount() {
        return money / LOTTO_PRICE;
    }

    private void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.AMOUNT_UNIT_ERROR.message);
        }
    }

}
