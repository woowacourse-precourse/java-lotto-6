package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoStatistics {

    private static final double PERCENTAGE = 100.0;
    private static final int DEFAULT_VALUE = 0;
    private static final int INCREMENT = 1;
    private final LinkedHashMap<Rank, Integer> rankHashMap;

    public LottoStatistics(LinkedHashMap<Rank, Integer> rankHashMap) {
        this.rankHashMap = rankHashMap;
    }

    public LinkedHashMap<Rank, Integer> getRankResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        LottoService lottoService = new LottoService(new ArrayList<>());
        Rank rank = lottoService.getLottoRank(lotto, winningNumbers, bonusNumber);
        rankHashMap.put(rank, rankHashMap.getOrDefault(rank, DEFAULT_VALUE) + INCREMENT);
        return new LinkedHashMap<>(rankHashMap);
    }

    public double calculateProfit(int playerMoney) {
        double totalPrize = rankHashMap.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (totalPrize / playerMoney) * PERCENTAGE;
    }

}
