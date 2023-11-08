package lotto;

import java.text.DecimalFormat;
public enum Prize {
    ZERO(0),
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final double prizeAmount;

    Prize(double prizeAmount) {
            this.prizeAmount = prizeAmount;
    }

    public double getPrizeAmount() {
            return prizeAmount;
    }
}
