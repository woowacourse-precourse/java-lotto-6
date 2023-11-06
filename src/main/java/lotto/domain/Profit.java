package lotto.domain;

import java.text.DecimalFormat;

public class Profit {

    DecimalFormat df = new DecimalFormat("#,##0.0");

    private final double value;

    public Profit(double value) {
        this.value = value;
    }

    public static Profit of(long money, long prize) {
        return new Profit(((double) prize / money) * 100);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return df.format(value);
    }
}
