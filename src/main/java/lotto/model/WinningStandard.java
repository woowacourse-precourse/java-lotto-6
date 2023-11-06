package lotto.model;

import java.util.List;

public enum WinningStandard {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FORTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    ETC(0, 0, false);

    private final int winningAmount;
    private final int matchCount;
    private final boolean isMatchBonus;

    WinningStandard(int winningAmount, int matchCount, boolean isMatchBonus) {
        this.winningAmount = winningAmount;
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
    }

    public static WinningStandard checkMatchNumbers(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getWinningNumbers().getNumbers();
        Integer bonusNumber = winningLotto.getBonusNumber();

        int matchCount = 0;
        boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);

        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        if (matchCount == 5 && hasBonusNumber) {
            return WinningStandard.SECOND;
        }

        return getWinnigStatndard(matchCount);
    }

    private static WinningStandard getWinnigStatndard(int matchCount) {
        for (WinningStandard standard : values()) {
            if (standard.matchCount == matchCount) {
                return standard;
            }
        }
        return ETC;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
