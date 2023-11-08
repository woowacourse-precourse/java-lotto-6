package lotto.domain;

import lotto.constants.Strings;

public enum PrizeGrade {
    FIRST(6, 2000000000, Strings.EMPTY),
    SECOND(5, 30000000, ", 보너스 볼 일치"),
    THIRD(5, 1500000, Strings.EMPTY),
    FOURTH(4, 50000, Strings.EMPTY),
    FIFTH(3, 5000, Strings.EMPTY),
    NO_PRIZE(0, 0, Strings.EMPTY);

    private final int matchCount;
    private final int prizeMoney;
    private final String additionalMessage;

    PrizeGrade(int matchCount, int prizeMoney, String additionalMessage) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.additionalMessage = additionalMessage;
    }


    public static PrizeGrade of(int matchCount, boolean matchWithBonus) {
        if (isSecond(matchCount, matchWithBonus)) {
            return SECOND;
        }
        return ofWithoutSecond(matchCount);
    }

    private static boolean isSecond(int matchCount, boolean matchWithBonus) {
        return (matchCount == SECOND.matchCount && matchWithBonus);
    }

    private static PrizeGrade ofWithoutSecond(int matchCount) {
        for (PrizeGrade prizeGrade : values()) {
            if (prizeGrade != SECOND && prizeGrade.getMatchCount() == matchCount) {
                return prizeGrade;
            }
        }
        return NO_PRIZE;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public String getAdditionalMessage() {
        return this.additionalMessage;
    }
}
