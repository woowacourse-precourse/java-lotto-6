package lotto.model;

import lotto.Lotto;
import java.util.List;

public class Shop {

    private static final int DEFAULT_COST = 1000;
    private static final int DIVIDE_REMAIN_VALUE = 0;

    private final int lottoCost;

    private Shop(final int lottoCost) {
        this.lottoCost = lottoCost;
    }

    public static Shop createDefault() {
        return new Shop(DEFAULT_COST);
    }

    public List<Lotto> createLottosAsPaid(final int money) {
        validateIsRemainValueCorrect(money);
        return null;
    }

    private void validateIsRemainValueCorrect(final int money) {
        if (money % lottoCost != DIVIDE_REMAIN_VALUE) {
            throw new IllegalArgumentException();
        }
    }
}
