package lotto.model;

import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> rankResult;

    public LottoResult(Lottos lottos, User user) {
        this.rankResult = lottos.saveRankResult(user);
    }

    public int getResult(Rank rank) {
        return rankResult.get(rank);
    }

    private double calEarnings() {
        double earnings = 0;
        for (Rank rank : Rank.values()) {
            earnings += (rankResult.get(rank) * rank.getPrize());
        }
        return earnings;
    }

    public double calEarningRate(int cost) {
        return (calEarnings() / cost) * 100;
    }

}
