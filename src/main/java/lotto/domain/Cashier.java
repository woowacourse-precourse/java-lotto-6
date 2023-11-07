package lotto.domain;

import static lotto.domain.lotto.LottoRule.PRICE;

public class Cashier {
    public final int calculateLotto(final int money) {
        if (isNotThousandUnit(money)) {
            throw new IllegalArgumentException();
        }
        return money / PRICE.getValue();
    }

    private boolean isNotThousandUnit(final int money) {
        if (money % PRICE.getValue() != 0) {
            return true;
        }
        return false;
    }
}
