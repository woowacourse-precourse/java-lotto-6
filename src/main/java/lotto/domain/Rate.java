package lotto.domain;

public class Rate {
    private static final double HUNDRED = 100.0;

    private final double rate;

    public Rate(int money, PrizeResult prizeResult) {
        this.rate = calculateRate(money, prizeResult);
    }

    private double calculateRate(int money, PrizeResult prizeResult) {
        double totalWinningPrize = prizeResult.sumWinningPrize();
        return (totalWinningPrize / money) * HUNDRED;
    }

    public double getRate() {
        return rate;
    }
}
