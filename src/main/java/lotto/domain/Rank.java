package lotto.domain;

import static lotto.util.NumberConstant.*;

public enum Rank {
    FIFTH(FIFTH_WINNINGS),
    FOURTH(FOURTH_WINNINGS),
    THIRD(THIRD_WINNINGS),
    SECOND(SECOND_WINNINGS),
    FIRST(FIRST_WINNINGS),
    LOSE(LOSE_LOTTO);

    private final Double PRIZE_MONEY;

    Rank(Double prizeMoney) {
        this.PRIZE_MONEY = prizeMoney;
    }

    public Double getPrizeMoney() {
        return PRIZE_MONEY;
    }
}
