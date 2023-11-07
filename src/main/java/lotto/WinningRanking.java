package lotto;

import java.util.Arrays;

public enum WinningRanking {

    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int countOfMatch;
    private final int winningAmount;

    WinningRanking(int countOfMatch, int winningAmount) {
        this.countOfMatch = countOfMatch;
        this.winningAmount = winningAmount;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static WinningRanking getWinningRanking(int countOfMatch, boolean matchOfBonusNumber) {
        return Arrays.stream(values())
                .filter(winningRanking -> winningRanking.countOfMatch == countOfMatch)
                .map(winningRanking -> validateSecondThird(countOfMatch, matchOfBonusNumber, winningRanking))
                .findFirst()
                .orElse(null);
    }

    private static WinningRanking validateSecondThird(int countOfMatch, boolean matchOfBonusNumber,
                                                      WinningRanking winningRanking) {
        if (countOfMatch == SECOND.countOfMatch && matchOfBonusNumber) {
            return SECOND;
        }
        if (countOfMatch == THIRD.countOfMatch && !matchOfBonusNumber) {
            return THIRD;
        }
        return winningRanking;
    }
}
