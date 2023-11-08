package lotto.constant;

import java.util.Optional;

public enum PrizeCalculator {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4,50000),
    FIVE_MATCH(5,1500000),
    FIVE_WITH_BONUS_MATCH(50,30000000),
    SIX_MATCH(6,2000000000);

    private final int matchCount;
    private final long prizeMoney;

    PrizeCalculator(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Optional<Long> findPrizeMoney(int matchCount) {
        for (PrizeCalculator prize : values()) {
            if (prize.matchCount == matchCount) {
                return Optional.of(prize.prizeMoney);
            }
        }
        return Optional.empty();
    }
}