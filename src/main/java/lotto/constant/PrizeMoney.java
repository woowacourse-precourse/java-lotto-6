package lotto.constant;

import lotto.util.DecimalFormatter;

public enum PrizeMoney {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    final int value;

    PrizeMoney(int value) {
        this.value = value;
    }

    String getValueAsDecimalFormat() {
        return DecimalFormatter.toNumberWithDelimiter(value);
    }
}
