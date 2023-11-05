package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonusNumberExists;
    private final int prize;

    LottoRank(int matchCount, boolean bonusNumberExists, int prize) {
        this.matchCount = matchCount;
        this.bonusNumberExists = bonusNumberExists;
        this.prize = prize;
    }

    public static LottoRank findRankByMatchCount(int matchCount, boolean bonusNumberExists) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .filter(lottoRank -> lottoRank.bonusNumberExists == bonusNumberExists)
                .findAny()
                .orElse(NONE);
    }
}
