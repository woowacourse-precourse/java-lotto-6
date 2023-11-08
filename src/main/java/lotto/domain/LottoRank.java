package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum LottoRank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    NONE(0, false, 0);


    private final int matchedCount;
    private final boolean matchesBonusNumber;
    private final int earnings;

    LottoRank(int matchedCount, boolean matchesBonusNumber, int earnings) {
        this.matchedCount = matchedCount;
        this.matchesBonusNumber = matchesBonusNumber;
        this.earnings = earnings;
    }

    public static LottoRank valueOf(int matchedCount, boolean isBonusNumberMatched) {
        if (matchedCount < FIFTH.matchedCount) {
            return NONE;
        }

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchedCount == matchedCount && rank.matchesBonusNumber == isBonusNumberMatched)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public int getEarnings() {
        return earnings;
    }

    public boolean isMatchesBonusNumber() {
        return matchesBonusNumber;
    }

    public int getMatchedCount() {
        return matchedCount;
    }
}