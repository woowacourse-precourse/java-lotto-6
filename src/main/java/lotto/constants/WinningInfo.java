package lotto.constants;

import java.util.Arrays;
import java.util.Optional;

public enum WinningInfo {
    FIRST_RANK(1, 6, false, 2000000000),
    SECOND_RANK(2, 5, true, 30000000),
    THIRD_RANK(3, 5, false, 1500000),
    FOURTH_RANK(4, 4, false, 50000),
    FIFTH_RANK(5, 3, false, 5000);

    private int rank;
    private int countOfMatch;
    private boolean isBonusWinning;
    private int amount;

    WinningInfo(int rank, int countOfMatch, boolean isBonusWinning, int amount) {
        this.rank = rank;
        this.countOfMatch = countOfMatch;
        this.isBonusWinning = isBonusWinning;
        this.amount = amount;
    }

    public static Optional<WinningInfo> of(int countOfMatch, boolean isBonusWinning) {
        return Arrays.stream(WinningInfo.values())
                .filter(winningInfo -> winningInfo.getCountOfMatch() == countOfMatch)
                .filter(winningInfo -> winningInfo.checkBonusWinning(isBonusWinning))
                .findFirst();
    }

    public int getRank() {
        return this.rank;
    }

    private boolean checkBonusWinning(boolean isBonusWinning) {
        return this.isBonusWinning == isBonusWinning;
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public int getAmount() {
        return this.amount;
    }
}
