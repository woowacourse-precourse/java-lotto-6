package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Rate {
    private static final int THOUSAND = 1000;
    private final double winningRate;

    public Rate(Money money, PrizeResult prizeResult) {
        this.winningRate = calculateWinningRate(money, prizeResult);
    }

    private double calculateWinningRate(Money money, PrizeResult prizeResult) {
        List<Prize> prizes = Arrays.asList(Prize.values());
        long totalPrizeMoney = calculateTotalPrizeMoney(prizes, prizeResult);
        double totalSpentMoney = money.getLottoCount() * THOUSAND;
        return (totalPrizeMoney * 0.1) / totalSpentMoney;
    }

    private long calculateTotalPrizeMoney(List<Prize> prizes, PrizeResult prizeResult) {
        return prizes.stream()
                .mapToLong(prize -> prize.getMoney() * prizeResult.getPrizeCount(prize))
                .sum();
    }

    public double getWinningRate() {
        return winningRate;
    }

    @Override
    public String toString() {
        return String.format("%.2f%%", winningRate * 100);
    }

    public double getRate() {
        return winningRate;
    }
}

