package model;

public class EarningRate {
    private static final int PERCENT = 100;
    private static final int DIGIT = 10;
    private static double earningRate;

    public EarningRate(int startMoney, int winningMoney) {
        double fullEarningRate = ((double) winningMoney / (double) startMoney) * PERCENT;
        this.earningRate = round(fullEarningRate);
    }

    public double getEarningRate() {
        return earningRate;
    }

    public void calculateEarningRate(int startMoney, int winningMoney) {
        double fullEarningRate = ((double) winningMoney / (double) startMoney) * PERCENT;
        this.earningRate = round(fullEarningRate);

    }

    public double round(double earningRate) {
        return ((double) Math.round(earningRate * DIGIT) / DIGIT);
    }
}
