package lotto.domain;

public class WinningCount {
    private final int winningCount;
    private final boolean hasBonusNumber;

    public WinningCount(int winningCount, boolean hasBonusNumber) {
        this.winningCount = winningCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
