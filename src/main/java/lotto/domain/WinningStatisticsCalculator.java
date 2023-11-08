package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class WinningStatisticsCalculator {
    private final HashMap<Winning, Integer> winning;
    private double totalPrizeMoney;

    public WinningStatisticsCalculator() {
        this.winning = new HashMap<>() {{
            put(Winning.FIRST, 0);
            put(Winning.SECOND, 0);
            put(Winning.THIRD, 0);
            put(Winning.FOURTH, 0);
            put(Winning.FIFTH, 0);
            put(Winning.BLANK, 0);
        }};

        totalPrizeMoney = 0;
    }

    public HashMap<Winning, Integer> getWinning() {
        return winning;
    }

    public void calculateNumberOfWins(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            increaseWinningHistoryType(getMatchNumbers(lotto, winningNumbers), isMatchBonusNumber(lotto, bonusNumber));
        }
    }

    private void increaseWinningHistoryType(int matchNumber, boolean matchBonus) {
        Winning prizeType = Winning.getWinningType(matchNumber, matchBonus);
        winning.put(prizeType, winning.get(prizeType) + 1);
        plusTotalPrizeMoney(prizeType.getPrizeMoney());
    }

    private void plusTotalPrizeMoney(int prizeMoney) {
        totalPrizeMoney += prizeMoney;
    }

    private int getMatchNumbers(Lotto lotto, Lotto winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningNumbers.getNumbers().stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private boolean isMatchBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public String calculateRateOfReturn(int amount) {
        totalPrizeMoney *= 1.0;
        return roundTowDecimalPlaces((totalPrizeMoney / amount) * 100);
    }

    private String roundTowDecimalPlaces(double rate) {
        return String.format("%.1f", rate);
    }
}

