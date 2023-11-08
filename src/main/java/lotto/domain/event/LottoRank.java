package lotto.domain.event;

import java.util.Arrays;
import lotto.util.LottoRankUtils;

public enum LottoRank {
    FIRST(6, 0, 2_000_000_000L),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    NO_MATCH(0, 0, 0);

    private final int matchingNumbers;
    private final int matchingBonusNumbers;
    private final long prizeMoney;

    LottoRank(int matchingNumbers, int matchingBonusNumbers, long prizeMoney) {
        this.matchingNumbers = matchingNumbers;
        this.matchingBonusNumbers = matchingBonusNumbers;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank of(int matchingNumbers, boolean isBonusMatched) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> LottoRankUtils.matches(rank, matchingNumbers, isBonusMatched))
                .findFirst()
                .orElse(NO_MATCH);
    }

    public boolean matches(int matchingNumbers, boolean isBonusMatched) {
        if (this.matchingNumbers != matchingNumbers) {
            return false;
        }
        if (this == SECOND) {
            return isBonusMatched;
        }
        return true;
    }


    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchingBonusNumbers() {
        return matchingBonusNumbers;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }
}
