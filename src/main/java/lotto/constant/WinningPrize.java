package lotto.constant;

import lotto.domain.LottoRank;
import lotto.domain.PurchasePrice;

public enum WinningPrize {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);

    private final int amount;

    WinningPrize(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
