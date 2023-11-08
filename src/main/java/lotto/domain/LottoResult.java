package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final int DEFAULT_VALUE = 0;

    private final Map<Rank, Integer> result;

    public LottoResult(List<Rank> ranks) {
        this.result = new HashMap<>();
        setResult(ranks);
    }

    private void initResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, DEFAULT_VALUE);
        }
    }

    private void setResult(List<Rank> ranks) {
        initResult();
        for (Rank rank : ranks) {
            result.put(rank, result.get(rank) + 1);
        }
    }

    public int getRankCount(Rank rank) {
        return result.get(rank);
    }

    private double getTotalPrizeMoney() {
        double total = 0;
        for (Rank rank : result.keySet()) {
            total += rank.getPrizeMoney() * result.get(rank);
        }
        return total;
    }

    public double getTotalEarningsRate(LottoPurchaseMoney lottoPurchaseMoney) {
        return getTotalPrizeMoney() / lottoPurchaseMoney.getMoney() * 100;
    }

}
