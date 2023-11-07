package lotto;

import java.util.Arrays;

public enum Statistic {
    MATCH_THREE(3, 5_000),
    MATCH_FOUR(4, 50_000),
    MATCH_FIVE(5, 1_500_000),
    MATCH_FIVE_WITH_BONUS(5, 3_000_000),
    MATCH_SIX(6, 2_000_000_000);

    private int matchCount;
    private int prize;

    Statistic(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Statistic getStatistic(int matchCount) {
        return Arrays.stream(values())
                .filter(s -> s.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("3개 이상 일치 하지 않음"));
    }

    public int getPrize() {
        return prize;
    }
}
