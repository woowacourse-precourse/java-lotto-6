package lotto.domain;

import java.util.Arrays;

public enum PrizeCondition {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - %d개"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - %d개"),
    NONE(0, false, 0, null);

    private final int matchingNumberCount;
    private final boolean requiresBonusMatch;
    private final long prize;
    private final String prizeResultFormat;

    PrizeCondition(int matchingNumberCount, boolean requiresBonusMatch, long prize, String prizeResultFormat) {
        this.matchingNumberCount = matchingNumberCount;
        this.requiresBonusMatch = requiresBonusMatch;
        this.prize = prize;
        this.prizeResultFormat = prizeResultFormat;
    }

    public static PrizeCondition findPrizeCondition(int matchingNumberCount, boolean containsBonus) {
        if (matchingNumberCount == 5) {
            return Arrays.stream(values())
                    .filter(condition -> condition.matchingNumberCount == matchingNumberCount && condition.requiresBonusMatch == containsBonus)
                    .findFirst()
                    .orElse(NONE);
        }

        return Arrays.stream(values())
                .filter(condition -> condition.matchingNumberCount == matchingNumberCount)
                .findFirst()
                .orElse(NONE);
    }

    public long getPrize() {
        return prize;
    }

    public String getPrizeResultFormat() {
        return prizeResultFormat;
    }
}
