package lotto.domain;

public class Rate {
    private final double rate;

    public Rate(Money money, RankResult rankResult) {
        this.rate = (getPrizeMoney(rankResult) * 0.1) / money.getTicket();
    }

    private long getPrizeMoney(RankResult rankResult) {
        int result = 0;

        for (Rank rank : Rank.values()) {
            result += rankResult.getRankCount(rank) * rank.getPrizeAmount();
        }
        return result;
    }

    public double getRate() {
        return rate;
    }
}
