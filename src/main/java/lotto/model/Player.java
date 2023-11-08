package lotto.model;

import static lotto.constant.NumberConstants.LOTTO_PRICE_UNIT;

public class Player {
    private int amount;

    public Player(int amount) {
        this.amount = amount;
    }

    public int calculateLottoCount() {
        return amount / LOTTO_PRICE_UNIT;
    }
}