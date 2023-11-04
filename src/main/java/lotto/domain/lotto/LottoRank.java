package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NO_RANK(0, 0);

    private static final int CHECK_MATCH_COUNT_VALUE = 5;
    private final int matchCount;
    private final int winningAmount;

    LottoRank(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public static LottoRank getRank (int count, boolean isBonus) {
        if (count == CHECK_MATCH_COUNT_VALUE) {
            return getRankWithBonus(isBonus);
        }

        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == count)
                .findAny()
                .orElse(NO_RANK);
    }

    private static LottoRank getRankWithBonus(boolean isBonus) {
        if (isBonus){
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }
}
