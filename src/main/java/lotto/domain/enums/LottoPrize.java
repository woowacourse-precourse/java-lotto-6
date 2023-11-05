package lotto.domain.enums;

public enum LottoPrize {
    FIRST(1, 2_000_000_000),
    SECOND(2, 30_000_000),
    THIRD(3, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(5, 5_000),
    NONE(0, 0);

    private final int rank;
    private final int prizeMoney;

    LottoPrize(int rank, int prizeMoney) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }
}
