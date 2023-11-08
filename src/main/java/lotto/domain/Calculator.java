package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    private final Map<Rank, Integer> rankCount = new HashMap<>();

    public Calculator() {
    }

    public int calculateTotalPrize(Map<Rank, Integer> rankCount) {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += rank.getPrizeMoney() * rankCount.getOrDefault(rank, 0);
        }
        return totalPrize;
    }

    public double calculateRateOfReturn(int totalPrize, Money money) {
        return ((double) totalPrize / money.getMoney()) * 100;
    }

    public Map<Rank, Integer> calculateRankCount(List<Lotto> userLottos, WinningNumbers winningNumbers,
                                                 BonusNumber bonusNumber) {
        for (Lotto lotto : userLottos) {
            int countOfMatch = calculateCountOfMatch(lotto, winningNumbers);
            boolean matchBonus = checkMatchBonus(lotto, bonusNumber);
            updateRankCount(lotto, countOfMatch, matchBonus);
        }
        return rankCount;
    }

    private int calculateCountOfMatch(Lotto lotto, WinningNumbers winningNumbers) {
        return lotto.countMatchingNumbers(winningNumbers);
    }

    private boolean checkMatchBonus(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.containsBonusNumber(bonusNumber);
    }

    private void updateRankCount(Lotto lotto, int countOfMatch, boolean matchBonus) {
        Rank rank = Rank.calculateRank(countOfMatch, matchBonus);
        rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
    }
}
