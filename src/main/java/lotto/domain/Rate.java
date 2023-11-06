package lotto.domain;

public class Rate {

    private final double rate;

    public Rate(Coin coin, RankResult rankResult) {
        this.rate = (getAllMoney(rankResult) * 0.1) / coin.getCoin();
    }

    private long getAllMoney(RankResult rankResult) {
        int result = 0;

        for (Rank rank : Rank.values()) {
            result += rankResult.getRankCount(rank) * rank.getMoney();
        }

        return result;
    }

    public double getRate() {
        return rate;
    }
}