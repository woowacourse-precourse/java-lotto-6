package lotto.domain.constants;

import static lotto.exception.ExceptionMessage.SYSTEM_ERROR;

import java.util.Arrays;
import lotto.exception.LottoGameException;

public enum MatchingCount {

    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final long count;

    MatchingCount(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public static MatchingCount from(final long count) {
        return Arrays.stream(MatchingCount.values())
                .filter(rank -> rank.getCount() == count)
                .findFirst()
                .orElseThrow(() -> LottoGameException.from(SYSTEM_ERROR));
    }
}
