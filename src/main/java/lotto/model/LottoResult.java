package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int DEFAULT_COUNT = 0;
    private static final int INCREMENT = 1;

    private final List<Lotto> lottos;

    public LottoResult(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Rank, Integer> checkResult(WinningLotto winningLotto) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = Rank.getRankByLotto(lotto, winningLotto);
            result.put(rank, result.getOrDefault(rank, DEFAULT_COUNT) + INCREMENT);
        }
        return result;
    }

    public double calculateReturnRatePercentage(Map<Rank, Integer> result, int money) {
        double totalReward = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
        double returnRate = totalReward / money * 100;
        return (double) Math.round(returnRate * 100) / 100.0;
    }
}

