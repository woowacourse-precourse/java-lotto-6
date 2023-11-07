package lotto.model;

public class Statistics {
    private final double rate;

    public Statistics(PurchaseAmountLotto purchaseAmountLotto, LottoResult result) {
        this.rate = (getMoney(result) * 0.1) / purchaseAmountLotto.getPurchaseLotto();
    }

    private long getMoney(LottoResult result) {
        int resultReward = 0;

        for (Rank rank : Rank.values()) {
            resultReward += result.getRankCount(rank) * rank.getReward();
        }
        return resultReward;
    }

    public double getRate() {
        return rate;
    }
}
