package lotto.model;

import java.util.stream.Stream;

public enum LottoPrize {
    NOTHING(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeAmount;
    private final boolean matchBonus;

    LottoPrize(int matchCount, int prizeAmount) {
        this(matchCount, prizeAmount, false);
    }

    LottoPrize(int matchCount, int prizeAmount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.matchBonus = matchBonus;
    }

    public static LottoPrize of(int matchCount, boolean hasBonusNumber) {
        if (isSecondPrize(matchCount, hasBonusNumber)) {
            return SECOND;
        }
        return from(matchCount);
    }

    private static boolean isSecondPrize(int matchCount, boolean hasBonusNumber) {
        return matchCount == SECOND.matchCount && hasBonusNumber;
    }

    private static LottoPrize from(int matchCount) {
        return Stream.of(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(NOTHING);
    }

    @Override
    public String toString() {
        return "LottoPrize{" +
                "matchCount=" + matchCount +
                ", prizeAmount=" + prizeAmount +
                ", matchBonus=" + matchBonus +
                '}';
    }
}
