package lotto.domain.prize.constants;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

import java.util.Arrays;

public enum PrizeMatchingCount {
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ONE(1),
    ZERO(0);

    private final int count;

    PrizeMatchingCount(int count) {
        this.count = count;
    }

    // Utility Method
    public static PrizeMatchingCount from(final int matchingCount) {
        return Arrays.stream(PrizeMatchingCount.values())
                .filter(grade -> isSameMatchingCount(matchingCount, grade))
                .findFirst()
                .orElseThrow(() -> LottoException.from(ErrorMessage.SYSTEM_CRASHED));
    }

    // Validation Method
    private static boolean isSameMatchingCount(int matchingCount, PrizeMatchingCount grade) {
        return grade.getCount() == matchingCount;
    }

    // Getter
    public int getCount() {
        return count;
    }
}
