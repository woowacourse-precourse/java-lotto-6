package lotto.model;

import java.util.Arrays;
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
        return Arrays.stream(Rank.values())
                .mapToInt(rank -> rankResult.get(rank) * rank.getPrize())
                .sum();
    }

    public double calEarningRate(int cost) {
        return (calEarnings() / cost) * 100;
    }

}
