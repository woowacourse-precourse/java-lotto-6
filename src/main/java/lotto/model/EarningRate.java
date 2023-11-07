package lotto.model;

import java.text.DecimalFormat;

public class EarningRate {
    private final String earningRate;

    public EarningRate(double amount, double earning) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.0%");
        earningRate = decimalFormat.format(earning / amount);
    }

    @Override
    public String toString() {
        return earningRate;
    }
}
