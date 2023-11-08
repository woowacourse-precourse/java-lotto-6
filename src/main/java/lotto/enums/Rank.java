package lotto.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FIFTH(3, false, "3개 일치 (5,000원)", 5_000L),
    FOURTH(4, false, "4개 일치 (50,000원)", 50_000L),
    THIRD(5, false, "5개 일치 (1,500,000원)", 1_500_000L),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000L),
    FIRST(6, false, "6개 일치 (2,000,000,000원)", 2_000_000_000L);

    private final int matchCount;
    private final boolean matchBonus;
    private final String message;
    private final Long prizeMoney;
    private Long prizeCount;

    Rank(int matchCount, boolean matchBonus, String message, Long prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.message = message;
        this.prizeMoney = prizeMoney;
        this.prizeCount = 0L;
    }

    public static void calculatePrizeCount(int matchCount, boolean matchBonus) {
        Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.matchBonus == matchBonus)
                .forEach(rank -> rank.prizeCount++);
    }

    public String getWinningDetail() {
        return this.message + " - " + this.prizeCount + "개";
    }

    public static Optional<Long> calculatePrizeMoney() {
        return Arrays.stream(values())
                .map(rank -> rank.prizeMoney * rank.prizeCount)
                .reduce(Long::sum);
    }
}
