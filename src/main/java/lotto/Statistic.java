package lotto;

import java.util.Arrays;

public enum Statistic {
    MATCH_THREE("3개 일치 (5,000원) - ", 3, 5_000),
    MATCH_FOUR("4개 일치 (50,000원) - ", 4, 50_000),
    MATCH_FIVE("5개 일치 (1,500,000원) - ", 5, 1_500_000),
    MATCH_FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 5, 3_000_000),
    MATCH_SIX("6개 일치 (2,000,000,000원) - ", 6, 2_000_000_000);

    private final String message;
    private final int matchCount;
    private final int prize;

    Statistic(String message, int matchCount, int prize) {
        this.message = message;
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

    public int getMatchCount() {
        return matchCount;
    }

    public String getMessage() {
        return message;
    }
}
