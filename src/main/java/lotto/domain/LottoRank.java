package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
    FIRST_PRIZE("6개 일치", 6, false, 2_000_000_000),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치", 5, true, 30_000_000),
    THIRD_PRIZE("5개 일치", 5, false, 1_500_000),
    FOURTH_PRIZE("4개 일치", 4, false, 50_000),
    FIFTH_PRIZE("3개 일치", 3, false, 5_000);

    private final String description;
    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;

    LottoRank(String description, int matchCount, boolean matchBonus, int prizeMoney) {
        this.description = description;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Optional<LottoRank> find(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .filter(lottoRank -> lottoRank.matchBonus == matchBonus)
                .findFirst();
    }

    public String getDescription() {
        return description;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
