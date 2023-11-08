package lotto.constant;

public enum WinningCount {
    LOTTO_WIN(6),
    SECOND_WIN(5),
    THIRD_WIN(5),
    FOURTH_WIN(4),
    FIFTH_WIN(3);
    private final int winningCount;

    WinningCount(Integer winningCount) {
        this.winningCount = winningCount;
    }

    public int getWinningCount() {
        return winningCount;
    }
}
