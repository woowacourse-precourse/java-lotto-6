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
    private int numberOfMatch;
    private boolean isBonusWinning;
    private int amount;

    WinningInfo(int rank, int numberOfMatch, boolean isBonusWinning, int amount) {
        this.rank = rank;
        this.numberOfMatch = numberOfMatch;
        this.isBonusWinning = isBonusWinning;
        this.amount = amount;
    }

    public static Optional<WinningInfo> of(int numberOfMatch, boolean isBonusWinning) {
        return Arrays.stream(WinningInfo.values())
                .filter(prizeOption -> prizeOption.getNumberOfMatch() == numberOfMatch)
                .filter(prizeOption -> prizeOption.checkBonusWinning(isBonusWinning))
                .findFirst();
    }

    public int getRank() {
        return this.rank;
    }

    private boolean checkBonusWinning(boolean isBonusWinning) {
        return this.isBonusWinning == isBonusWinning;
    }

    public int getNumberOfMatch() {
        return this.numberOfMatch;
    }

    public int getAmount() {
        return this.amount;
    }
}
