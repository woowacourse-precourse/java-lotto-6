package lotto.domain;

import java.util.Arrays;

public enum LottoResult {

    FIFTH(3,5000),
    FOURTH(4, 50000),
    THIRD(5,1500000),
    SECOND(5,30000000),
    FIRST(6,2000000000);

    private final int matchCount;
    private final int prize;

    LottoResult(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoResult findRank(int matchCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(result -> result.matchCount == matchCount)
                .filter(result -> matchCount != 5 || !hasBonus || result != THIRD)
                .findFirst()
                .orElse(null);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
