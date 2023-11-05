package lotto.model;

import java.util.Arrays;

public enum Rank {
    NO_RANK(0, 0L, ""),
    FIFTH(3, 5_000L, "3개 일치 (5,000원) - "),
    FOURTH(4, 50_000L, "4개 일치 (50,000원) - "),
    THIRD(5, 1_5000_000L, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000L, "6개 일치 (2,000,000,000원) - ");

    private int matchCount;
    private long prizeMoney;
    private String message;

    Rank(int matchCount, long prizeMoney, String message) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    public static Rank valueOf(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }
}
