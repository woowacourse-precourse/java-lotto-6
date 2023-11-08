package lotto.constant;

import java.math.BigDecimal;

public enum WinningPrize {
    FIRST_PLACE_AMOUNT(BigDecimal.valueOf(2000000000L)),
    SECOND_PLACE_AMOUNT(BigDecimal.valueOf(30000000)),
    THIRD_PLACE_AMOUNT(BigDecimal.valueOf(1500000)),
    FOURTH_PLACE_AMOUNT(BigDecimal.valueOf(50000)),
    FIFTH_PLACE_AMOUNT(BigDecimal.valueOf(5000));

    private final BigDecimal value;

    WinningPrize(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
