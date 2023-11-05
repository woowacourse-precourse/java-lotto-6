package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
    FIRST(6, false, "1등: 6개 번호 일치 / 2,000,000,000원"),
    SECOND(5, true, "2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원"),
    THIRD(5, false, "3등: 5개 번호 일치 / 1,500,000원"),
    FOURTH(4, false, "4등: 4개 번호 일치 / 50,000원"),
    FIFTH(3, false, "5등: 3개 번호 일치 / 5,000원");


    private final int matchCount;
    private final boolean matchBonus;

    private final String message;

    LottoRank(int matchCount, boolean matchBonus, String message) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.message = message;
    }

    public static Optional<LottoRank> valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> !rank.matchBonus || matchBonus)
                .findFirst();
    }
}

