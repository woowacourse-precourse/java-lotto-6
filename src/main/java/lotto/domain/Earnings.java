package lotto.domain;

public class Earnings {

    private final double earningsRate;

    private Earnings(double earningsRate) {
        this.earningsRate = earningsRate;
    }

    public static Earnings calculate(int price, int prize) {
        double earningsRate = ((double) prize - price) / price;
        return new Earnings(earningsRate);
    }

    public double getEarningsRate() {
        // 소수점 둘째 자리 반올림
        return Math.round(earningsRate * 100) / 100.0;
    }
}
