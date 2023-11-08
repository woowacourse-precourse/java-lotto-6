package lotto;

import java.text.DecimalFormat;
public enum Prize {
    ZERO(0),
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int prizeAmount;

    Prize(int prizeAmount) {
            this.prizeAmount = prizeAmount;
    }

    public int getPrizeAmount() {
            return prizeAmount;
    }

    public String getFormattedPrizeAmount() {
            DecimalFormat df = new DecimalFormat("#,###");
            return df.format(prizeAmount);
    }

    public int multiplyAndAdd(int multiplier, int addition) {
            return prizeAmount + (multiplier * addition);
    }

}
