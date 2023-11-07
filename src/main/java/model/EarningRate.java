package model;

public class EarningRate {
    private static final int PERCENT = 100;
    private static final int DIGIT = 10;

    public double calculateEarningRate(int startMoney, int winningMoney) {
        double earningRate = ((double) winningMoney / (double) startMoney) * PERCENT;
        return round(earningRate);
    }

    public double round(double earningRate) {
        return ((double) Math.round(earningRate * DIGIT) / DIGIT);
    }
}
