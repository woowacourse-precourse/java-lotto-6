package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    BLANK(0, 0, "꽝");

    private final int matchCount;
    private final int prizeMoney;
    private final String winningMessage;

    Rank(int matchCount, int prizeMoney, String winningMessage) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.winningMessage = winningMessage;
    }

    public static Rank of(int matchCount, boolean isBonus) {
        if (isBonus && matchCount == SECOND.matchCount) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(value -> !value.equals(SECOND) && value.matchCount == matchCount)
                .findFirst()
                .orElse(BLANK);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

}
