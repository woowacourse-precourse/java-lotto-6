package lotto.domain;

import lotto.config.LottoConfig;
import lotto.config.ErrorMessages;

public class LottoCost {
    private final int cost;
    private final int ticket;

    public LottoCost(int cost) {
        isMultipleOfUnit(cost);

        this.cost = cost;
        ticket = this.cost / LottoConfig.UNIT;
    }

    public int getCost() {
        return cost;
    }

    public int getNumberOfLotto() {
        return ticket;
    }

    private void isMultipleOfUnit(int cost) {
        boolean isRemainderZero =
                (cost >= LottoConfig.UNIT && cost < Integer.MAX_VALUE && cost % LottoConfig.UNIT == 0);

        if (!isRemainderZero) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_MULTIPLE_OF_UNIT.getMessage());
        }
    }
}
