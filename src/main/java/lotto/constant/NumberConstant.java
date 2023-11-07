package lotto.constant;

import java.math.BigDecimal;

public enum NumberConstant {
    HUNDRED(BigDecimal.valueOf(100));

    private final BigDecimal number;

    NumberConstant(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal getValue() {
        return number;
    }
}
