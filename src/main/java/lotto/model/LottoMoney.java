package lotto.model;

import static lotto.model.constant.ErrorMessage.MONEY_INVALID_AMOUNT_UNIT;
import static lotto.model.constant.ErrorMessage.MONEY_INVALID_MINIMUM_AMOUNT;
import static lotto.model.constant.LottoConfig.LOTTO_AMOUNT;

public class LottoMoney {

    private final int money;

    public LottoMoney(int money) {
        validateOverZero(money);
        validateWonUnit(money);
        this.money = money;
    }

    public int availableLottoCount() {
        return this.money / LOTTO_AMOUNT;
    }

    public int getMoney() {
        return this.money;
    }

    private void validateOverZero(int money) {
        if (isOverMinimum(money)) {
            throw new IllegalArgumentException(MONEY_INVALID_MINIMUM_AMOUNT);
        }
    }

    private void validateWonUnit(int money) {
        if (money % LOTTO_AMOUNT != 0) {
            throw new IllegalArgumentException(MONEY_INVALID_AMOUNT_UNIT);
        }
    }

    private static boolean isOverMinimum(int money) {
        return money < LOTTO_AMOUNT;
    }
}
