package lotto.model;

import java.text.DecimalFormat;

public class RateOfReturn {
    private static double returnOfRate;
    private final int winningMoney;
    private final int myMoney;

    public RateOfReturn(int winningMoney, int myMoney) {
        this.winningMoney = winningMoney;
        this.myMoney = myMoney;
    }

    private void calculateReturn() {
        returnOfRate = (double) winningMoney / myMoney;
    }

    private void decimalReturn() {
        calculateReturn();
        returnOfRate *= 100.0;
    }

    public double getReturnOfRate() {
        decimalReturn();
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedValue = df.format(returnOfRate);
        return Double.parseDouble(formattedValue);
    }
}
