package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Statistics {

    private final Map<Rank, Integer> stats;
    private final double profitRate;

    public Statistics(Money money, LottoBundle lottoBundle, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.stats = new HashMap<>();
        for (Rank rank : Rank.values()) {
            this.stats.put(rank, 0);
        }

        compileStats(lottoBundle, winningNumbers, bonusNumber);
        profitRate = computeProfitRate(money);
    }

    private void compileStats(LottoBundle lottoBundle, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : lottoBundle) {
            Rank matchRank = match(lotto, winningNumbers, bonusNumber);
            stats.put(matchRank, stats.get(matchRank) + 1);
        }
    }

    private Rank match(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Integer matchWinning = winningNumbers.match(lotto);
        Integer matchBonus = bonusNumber.match(lotto);

        if (matchWinning.equals(Rank.SECOND.getMatchWinning())) {
            matchBonus = 0;
        }

        for (Rank rank : Rank.values()) {
            if (rank.getMatchWinning().equals(matchWinning) && rank.getMatchBonus().equals(matchBonus)) {
                return rank;
            }
        }

        return Rank.OTHER;
    }

    private double computeProfitRate(Money money) {
        long profit = 0;

        for (Entry<Rank, Integer> entry : stats.entrySet()) {
            profit += entry.getKey().getPrize() * entry.getValue();
        }

        return ((double) profit) / money.getMoney() * 100;
    }

    public int getStat(Rank rank) {
        return stats.get(rank);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
