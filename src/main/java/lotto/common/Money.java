package lotto.common;

import java.text.NumberFormat;
import java.util.Locale;

public enum Money {
    RANK1(2000000000),
    RANK2(30000000),
    RANK3(1500000),
    RANK4(50000),
    RANK5(5000);

    private final int cash;

    Money(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public String getCashToString() {
        return NumberFormat.getNumberInstance(Locale.US).format(cash);
    }

}
