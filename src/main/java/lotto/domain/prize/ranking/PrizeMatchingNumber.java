package lotto.domain.prize.ranking;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public enum PrizeMatchingNumber {
    FIFTH(3),
    FOURTH(4),
    THIRD(5),
    SECOND(5),
    FIRST(6),
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
