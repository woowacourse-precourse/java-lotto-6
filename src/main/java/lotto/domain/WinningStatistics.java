package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class WinningStatistics {
    private final HashMap<Rank, Integer> winningHistory;
    private double totalPrizeMoney;

    //초기화
    public WinningStatistics() {
        this.winningHistory = new HashMap<>() {{
            put(Rank.FIRST_PRIZE, 0);
            put(Rank.SECOND_PRIZE, 0);
            put(Rank.THIRD_PRIZE, 0);
            put(Rank.FOURTH_PRIZE, 0);
            put(Rank.FIFTH_PRIZE, 0);
            put(Rank.BLANK, 0);
        }};

        totalPrizeMoney = 0;
    }

    public HashMap<Rank, Integer> getWinningHistory() {
        return winningHistory;
    }

    public void calculateNumberOfWins(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            increaseWinningHistoryType(getMatchNumbers(lotto, winningNumbers), isMatchBonusNumber(lotto, bonusNumber));
        }
    }

    private void increaseWinningHistoryType(int matchNumbers, Boolean matchBonusNumber) {
        Rank prizeType = Rank.getWinningHistoryType(matchNumbers, matchBonusNumber);
        winningHistory.put(prizeType, winningHistory.get(prizeType) + 1);
        plusTotalPrizeMoney(prizeType.getPrizeMoney());
    }

    private void plusTotalPrizeMoney(int prizeMoney) {
        totalPrizeMoney += prizeMoney;
    }

    private Boolean isMatchBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getLotto().contains(bonusNumber);
    }

    private int getMatchNumbers(Lotto lotto, Lotto winningNumbers) {
        return (int) lotto.getLotto().stream()
                .filter(numbers -> winningNumbers.getLotto().stream().anyMatch(Predicate.isEqual(numbers)))
                .count();
    }

    public String calculateRateOfReturn(int price) {
        totalPrizeMoney *= 1.0;
        return roundTwoDecimalPlaces((totalPrizeMoney / price) * 100);
    }

    private String roundTwoDecimalPlaces(double rate) {
        return String.format("%.1f", rate);
    }
}
