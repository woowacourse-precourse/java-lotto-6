package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000L, "1등: 6개 번호 일치"),
    SECOND(5, true, 30_000_000L, "2등: 5개 번호 + 보너스 번호 일치"),
    THIRD(5, false, 1_500_000L, "3등: 5개 번호 일치"),
    FOURTH(4, false,50_000L, "4등: 4개 번호 일치 / 50,000원"),
    FIFTH(3, false,5_000L, "5등: 3개 번호 일치 / 5,000원");

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
    public static Optional<LottoRank> valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> !rank.matchBonus || matchBonus)
                .findFirst();
    }
}

