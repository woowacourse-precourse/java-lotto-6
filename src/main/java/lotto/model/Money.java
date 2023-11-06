package lotto.model;

import static lotto.model.constant.LottoConfig.LOTTO_AMOUNT;
import static lotto.model.constant.LottoConfig.ZERO;

public class Money {

    private final int money;

    public Money(int money) {
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
            throw new IllegalArgumentException("[ERROR] 돈은 1,000원 이상 입력가능합니다.");
        }
    }

    private void validateWonUnit(int money) {
        if (money % LOTTO_AMOUNT != ZERO) {
            throw new IllegalArgumentException("[ERROR] 돈은 1,000원 단위로 입력가능합니다.");
        }
    }

    private static boolean isOverMinimum(int money) {
        return money < LOTTO_AMOUNT;
    }
}
