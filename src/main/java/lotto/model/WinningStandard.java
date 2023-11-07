package lotto.model;

import java.util.List;

public enum WinningStandard {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FORTH(50_000, 4),
    FIFTH(5_000, 3),
    ETC(0, 0);

    private final int winningAmount;
    private final int matchCount;

    WinningStandard(int winningAmount, int matchCount) {
        this.winningAmount = winningAmount;
        this.matchCount = matchCount;
    }

    public static WinningStandard getWinningRanking(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getWinningNumbers().getNumbers();
        Integer bonusNumber = winningLotto.getBonusNumber();

        int matchCount = calculateMatchCount(lotto, winningNumbers);
        boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);

        return calculatetWinningStandard(matchCount, hasBonusNumber);
    }

    private static int calculateMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static WinningStandard calculatetWinningStandard(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 5) {
            if (hasBonusNumber) {
                return WinningStandard.SECOND;
            } else {
                return WinningStandard.THIRD;
            }
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

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
