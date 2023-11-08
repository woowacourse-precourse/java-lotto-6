package lotto.domain.prize.ranking;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public enum PrizeMatchingNumber {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    ;

    private final int matchCount;

    PrizeMatchingNumber(final int matchCount) {
        validatePositiveMatchCount(matchCount);
        this.matchCount = matchCount;
    }

    private void validatePositiveMatchCount(final int matchCount) {
        if (matchCount < 0) {
            throw LottoException.of(ErrorMessage.INVALID_PRIZE_MATCH_COUNT_NEGATIVE);
        }
    }

    public int getMatchCount() {
        return matchCount;
    }
}
