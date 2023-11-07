package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultCalculator {
    public static final String RESULT_MESSAGE_FORMAT = "%s - %d개";
    public static final int MATCH_COUNT_FIVE = 5;
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
        return matchCount == MATCH_COUNT_FIVE && lotto.getNumbers().contains(bonusNumber);
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

    public void calculateProfitRate(int amount) {
        int totalProfit = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        profitRate = (double) totalProfit / amount * 100;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public double getProfitRate() { return profitRate; }

    @Override
    public String toString() {
        return result.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.OUT_OF_RANKS)
                .map(entry -> String.format(RESULT_MESSAGE_FORMAT, entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
