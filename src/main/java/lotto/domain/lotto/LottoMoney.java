package lotto.domain.lotto;

import lotto.domain.message.ErrorMessage;

public class LottoMoney {

    public static final int PERCENT = 100;

    private static final int ZERO = 0;

    private final int money;

    public LottoMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money == ZERO || money % LottoRule.LOTTO_PRICE.getValue() != ZERO) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_EXCEPTION_MESSAGE.getMessage());
        }
    }

    public int calculatePurchasableCount() {
        return money / LottoRule.LOTTO_PRICE.getValue();
    }

    public float calculateProfitRate(float winningMoney) {
        return (winningMoney / money) * PERCENT;
    }
}
