package lotto.domain;

public class Yield {

    private final Money purchaseMoney;
    private final Money reward;
    private double yield;

    public Yield(Money purchaseMoney, Money reward) {
        this.purchaseMoney = purchaseMoney;
        this.reward = reward;
        this.yield = calculateYield();
    }

    @Override
    public String toString() {
        return String.format("%.1f%%", yield);
    }

    private double calculateYield() {
        return reward.getValue() / (double) purchaseMoney.getValue() * 100;
    }
}
