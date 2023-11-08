package lotto.domain;

import lotto.utils.GameRules;

public enum Prize {
    NOTHING(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);
    private final int matchedCount;
    private final int prizeAmount;

    Prize(int matchedCount, int prizeAmount) {
        this.matchedCount = matchedCount;
        this.prizeAmount = prizeAmount;
    }

    public static Prize valueOf(int matchedNumbers, boolean matchedBonus) {
        if (matchedNumbers < GameRules.MINIMUM_WIN_COUNT.getValue()) {
            return NOTHING;
        }
        if ((SECOND.getMatchedCount() == matchedNumbers) && matchedBonus) {
            return SECOND;
        }
        for (Prize prize : values()) {
            if ((prize.getMatchedCount() == matchedNumbers) && prize != SECOND) {
                return prize;
            }
        }
        throw new IllegalArgumentException();
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
