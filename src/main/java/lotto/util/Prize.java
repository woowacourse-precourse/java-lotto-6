package lotto.util;

import java.math.BigDecimal;

public enum Prize {
    FIFTH_PRIZE(new BigDecimal("5000")),
    FOURTH_PRIZE(new BigDecimal("50000")),
    THIRD_PRIZE(new BigDecimal("1500000")),
    SECOND_PRIZE(new BigDecimal("30000000")),
    FIRST_PRIZE(new BigDecimal("2000000000"));

    private final BigDecimal prize;

    Prize(BigDecimal prize) {
        this.prize = prize;
    }

    public BigDecimal getPrize() {
        return prize;
    }
}
