package lotto.model;

import static lotto.model.constant.LottoConfig.LOTTO_AMOUNT;
import static lotto.model.constant.LottoConfig.ZERO;

public class Money {

    private final Integer money;

    public Money(Integer money) {
        validateOverZero(money);
        validateWonUnit(money);
        this.money = money;
    }

    public Integer availableLottoCount() {
        return this.money / LOTTO_AMOUNT;
    }

    public Integer getMoney() {
        return this.money;
    }

    private void validateOverZero(Integer money) {
        if (isOverMinimum(money)) {
            throw new IllegalArgumentException("[ERROR] 돈은 1,000원 이상 입력가능합니다.");
        }
    }

    private void validateWonUnit(Integer money) {
        if (money % LOTTO_AMOUNT != ZERO) {
            throw new IllegalArgumentException("[ERROR] 돈은 1,000원 단위로 입력가능합니다.");
        }
    }

    private static boolean isOverMinimum(Integer money) {
        return money < LOTTO_AMOUNT;
    }
}
