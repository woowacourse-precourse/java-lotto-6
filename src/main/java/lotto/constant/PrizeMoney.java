package lotto.constant;

import lotto.util.DecimalFormatter;

public enum PrizeMoney {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final long value;

    PrizeMoney(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    String getValueWithDelimiter() {
        return DecimalFormatter.toNumberWithDelimiter(value);
    }

}
