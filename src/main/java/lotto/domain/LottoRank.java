package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {

    FIFTH(3, false, 5_000L, PrintMessages.MATCH_3.getMessage()),
            FOURTH(4, false, 50_000L, PrintMessages.MATCH_4.getMessage()),
            THIRD(5, false, 1_500_000L, PrintMessages.MATCH_5.getMessage()),
            SECOND(5, true, 30_000_000L, PrintMessages.MATCH_5_BONUS.getMessage()),
            FIRST(6, false, 2_000_000_000L, PrintMessages.MATCH_6.getMessage());

    private final int matchCount;
    private final boolean matchBonus;
    private final long prizeMoney;
    private final String description;

    LottoRank(int matchCount, boolean matchBonus, long prizeMoney, String description) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    public static Optional<LottoRank> valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> !rank.matchBonus || matchBonus)
                .findFirst();
    }
}

