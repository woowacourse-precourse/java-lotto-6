package lotto;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoResult {
    NO_MATCHING(0, BigDecimal.ZERO),
    THREE_MATCHING(3L, new BigDecimal(5000)),
    FOUR_MATCHING(4L, new BigDecimal(50000)),
    FIVE_MATCHING(5L, new BigDecimal(1500000)),
    SIX_MATCHING(6L, new BigDecimal(30000000)),
    FIVE_AND_BONUS_MATCHING(7L, new BigDecimal(2000000000));

    private final long matchingNumber;
    private final BigDecimal price;

    LottoResult(long matchingNumber, BigDecimal price) {
        this.matchingNumber = matchingNumber;
        this.price = price;
    }

    public static LottoResult from(long count) {
        return Arrays.stream(LottoResult.values())
                .filter(result -> result.isMatching(count))
                .findFirst()
                .orElse(NO_MATCHING);
    }

    private boolean isMatching(long count) {
        return matchingNumber == count;
    }
}
