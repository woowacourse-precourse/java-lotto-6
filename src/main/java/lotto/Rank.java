package lotto;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5000, "3개 일치 (5,000원) - "),
    NO_RANK(0, false, 0, "");

    private final int matchCount;
    private final boolean bonus;
    private final int cashPrize;
    private final String message;

    Rank(int matchCount, boolean bonus, int cashPrize, String message) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.cashPrize = cashPrize;
        this.message = message;
    }

    public static Rank getRank(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.bonus == bonus)
                .findAny()
                .orElse(NO_RANK);
    }
}