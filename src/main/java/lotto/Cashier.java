package lotto;

import static lotto.LottoRule.PRICE;

public class Cashier {
    public int calculateLotto(int money) {
        if (money % PRICE.getValue() != 0) {
            throw new IllegalArgumentException();
        }
        return money / PRICE.getValue();
    }
}
