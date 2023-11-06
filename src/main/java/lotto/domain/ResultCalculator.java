package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultCalculator {
    private final Map<Rank, Integer> result;
    private double profitRate;

    public ResultCalculator() {
        result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void calculateWinningCounts(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(winningLotto.getWinningNumber(), lotto);
            boolean matchBonus = isBonusNumberMatch(matchCount, winningLotto.getBonusNumber(), lotto);
            Rank rank = findRank(matchCount, matchBonus);
            updateResult(rank);
        }
    }

    private int countMatchingNumbers(Lotto winningNumber, Lotto lotto) {
        return (int) winningNumber.getNumbers().stream().filter(lotto.getNumbers()::contains).count();
    }

    private boolean isBonusNumberMatch(int matchCount, int bonusNumber, Lotto lotto) {
        return matchCount == 5 && lotto.getNumbers().contains(bonusNumber);
    }

    private Rank findRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount && rank.getMatchBonus() == matchBonus)
                .findFirst()
                .orElse(Rank.OUT_OF_RANKS);
    }

    private void updateResult(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public void calculateProfitRate(int amount) {
        int totalProfit = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        profitRate = (double) totalProfit / amount * 100;
    }

    public double getProfitRate() { return profitRate; }

    @Override
    public String toString() {
        return result.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.OUT_OF_RANKS)
                .map(entry -> entry.getKey() + " - " + entry.getValue() + "개")
                .collect(Collectors.joining("\n"));
    }
}
