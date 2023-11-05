package lotto.fixture;

import lotto.model.Money;

public class MoneyFixture {

    public static Money createMoney(final String amount) {
        return Money.from(amount);
    }
}
