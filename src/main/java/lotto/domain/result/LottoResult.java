package lotto.domain.result;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoResult {
    NO_MATCHING(0, BigDecimal.ZERO, ""),
    THREE_MATCHING(3L, new BigDecimal(5000), "3개 일치 (5,000원) - "),
    FOUR_MATCHING(4L, new BigDecimal(50000), "4개 일치 (50,000원) - "),
    FIVE_MATCHING(5L, new BigDecimal(1500000), "5개 일치 (1,500,000원) - "),
    SIX_MATCHING(6L, new BigDecimal(30000000), "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIVE_AND_BONUS_MATCHING(7L, new BigDecimal(2000000000), "6개 일치 (2,000,000,000원) - ");

    private final long matchingNumber;
    private final BigDecimal price;
    private final String message;

    LottoResult(long matchingNumber, BigDecimal price, String message) {
        this.matchingNumber = matchingNumber;
        this.price = price;
        this.message = message;
    }

    public static LottoResult from(long count) {
        return Arrays.stream(LottoResult.values())
                .filter(result -> result.isMatching(count))
                .findFirst()
                .orElse(NO_MATCHING);
    }

    public String getMessage() {
        return message;
    }

    public boolean isWinner() {
        return this != NO_MATCHING;
    }

    public BigDecimal getTotalPrice(int count) {
        return this.price
                .multiply(new BigDecimal(count));
    }

    private boolean isMatching(long count) {
        return matchingNumber == count;
    }
}
