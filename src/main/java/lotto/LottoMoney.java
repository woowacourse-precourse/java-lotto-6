package lotto;

import msg.ErrorMessage;

public class LottoMoney {
    private final int money;

    public LottoMoney(int money) {
        verify(money);
        this.money = money;
    }

    private void verify(int money) {
        if (money % LottoConfig.PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT.value());
        }
    }

    public int getAmount() {
        return money / LottoConfig.PRICE;
    }
}
