package lotto.domain;

import java.util.*;

public class LottoResult {
    private final Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);

    public LottoResult(List<Rank> ranks) {
        ranks.forEach(rank -> {
            rankCount.put(rank, countRank(rank) + 1);
        });
    }

    public double getProfitRate(LottoMoney money) {
        return getWinningMoney() / money.money();
    }

    public Integer countRank(Rank rank) {
        return rankCount.getOrDefault(rank, 0);
    }

    private Double getWinningMoney() {
        return rankCount.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }
}
