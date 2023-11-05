package lotto.domain;

import lotto.Configuration;

public enum WinningAmount {
    DEFAULT(0)
    , FIRST(Configuration.FIRST_WINNING_AMOUNT)
    , SECOND(Configuration.SECOND_WINNING_AMOUNT)
    , THIRD(Configuration.THIRD_WINNING_AMOUNT)
    , FOURTH(Configuration.FOURTH_WINNING_AMOUNT)
    , FIFTH(Configuration.FIFTH_WINNING_AMOUNT);

    private final int value;

    WinningAmount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
