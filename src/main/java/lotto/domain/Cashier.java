package lotto.domain;

import static lotto.domain.lotto.LottoRule.PRICE;
import static lotto.util.ErrorMessage.NOT_THOUSAND_UNIT;

public class Cashier {
    private static final int FIT_THOUSAND = 0;

    public final int calculateMoney(final int money) {
        if (isNotThousandUnit(money)) {
            throw new IllegalArgumentException(NOT_THOUSAND_UNIT.getMessage());
        }
        return money / PRICE.getValue();
    }

    private boolean isNotThousandUnit(final int money) {
        if (money % PRICE.getValue() != FIT_THOUSAND) {
            return true;
        }
        return false;
    }
}
