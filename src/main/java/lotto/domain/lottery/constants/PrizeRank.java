package lotto.domain.lottery.constants;

public enum PrizeRank {
    HIT_THREE(5_000, 3),
    HIT_FOUR(50_000, 4),
    HIT_FIVE(30_000_000, 5),
    HIT_FIVE_AND_BONUS(1_500_000, 5),
    HIT_SIX(200_000_000, 6);

    private final int prizeMoney;
    private final int targetCount;

    PrizeRank(
            int prizeMoney,
            int targetCount
    ) {
        this.prizeMoney = prizeMoney;
        this.targetCount = targetCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
