package lotto.domain;

public class Rate {
    private final double rate;

    public Rate(int money, PrizeResult lottoResult) {
        this.rate = calculateRate(money, lottoResult);
    }

    private double calculateRate(int money, PrizeResult lottoResult) {
        double totalWinningPrize = 0.0;

        for (Prize rank : Prize.values()) {
            totalWinningPrize += lottoResult.getPrizeCount(rank) * rank.getWinningPrize();
        }

        return (totalWinningPrize / money) * 100.0;
    }

    public double getRate() {
        return rate;
    }
}
