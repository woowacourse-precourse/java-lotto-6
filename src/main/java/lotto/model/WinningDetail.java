package lotto.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningDetail {
    private final Map<Ranking, Integer> winningCount;

    public WinningDetail(List<Lotto> lottos, WinningNumbers winningNumbers) {
        winningCount = new HashMap<>();
        init(lottos, winningNumbers);
    }

    private void init(List<Lotto> lottos, WinningNumbers winningNumbers) {
        initWinningCount();
        computeWinningCount(lottos, winningNumbers);
    }

    private void initWinningCount() {
        List<Ranking> rankings = Ranking.getRankings();
        rankings.forEach(ranking -> winningCount.put(ranking, 0));
    }

    private void computeWinningCount(List<Lotto> lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            Ranking ranking = lotto.getRanking(winningNumbers.getWinningNumber(), winningNumbers.getBonusNumber());
            updateWinningCount(ranking);
        }
    }

    private void updateWinningCount(Ranking ranking) {
        winningCount.put(ranking, winningCount.get(ranking) + 1);
    }

    public Map<Ranking, Integer> getWinningCount() {
        return Collections.unmodifiableMap(winningCount);
    }

    public long totalProfit() {
        return winningCount.keySet().stream().mapToLong(ranking -> calculateProfit(ranking, winningCount.get(ranking)))
                .sum();
    }

    private long calculateProfit(Ranking ranking, int amount) {
        return (long) amount * ranking.getWinningAmount();
    }
}
