package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoResult {

    private static final double PERCENTAGE = 100.0;
    private final LinkedHashMap<Rank, Integer> rankHashMap;

    public LottoResult(LinkedHashMap<Rank, Integer> rankHashMap) {
        this.rankHashMap = rankHashMap;
    }

    public LinkedHashMap<Rank, Integer> getRankResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        LottoService lottoService = new LottoService(new ArrayList<>());

        Rank rank = lottoService.getLottoRank(lotto, winningNumbers, bonusNumber);
        rankHashMap.put(rank, rankHashMap.getOrDefault(rank, 0) + 1);
        return new LinkedHashMap<>(rankHashMap);
    }

    public double calculateProfit(int playerMoney) {
        double sum = 0;
        for (Rank rank : rankHashMap.keySet()) {
            int prize = rank.getPrize();;
            int number = rankHashMap.get(rank);
            sum += prize * number;
        }
        return (sum / playerMoney) * PERCENTAGE;
    }

}
