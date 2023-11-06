package lotto.model;

public enum LottoPrize {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_AND_BONUS_MATCH(-1, 30_000_000),
    SIX_MATCH(6, 2_000_000_000);

    private final int matchCount;
    private final long prize;

    LottoPrize(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public String getDescription() {
        return switch (this) {
            case THREE_MATCH -> "3개 일치";
            case FOUR_MATCH -> "4개 일치";
            case FIVE_MATCH -> "5개 일치";
            case FIVE_AND_BONUS_MATCH -> "5개 일치, 보너스 볼 일치";
            case SIX_MATCH -> "6개 일치";
        };
    }

    public static LottoPrize valueOf(int matchCount) {
        for (LottoPrize prize : values()) {
            if (prize.getMatchCount() == matchCount) {
                return prize;
            }
        }
        return null;
    }


    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }
}