package domain;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int winningNumberCount;
    private final boolean hasBonusNumber;
    private final int prize;

    Rank(int winningNumberCount, boolean hasBonusNumber, int prize) {
        this.winningNumberCount = winningNumberCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public int getWinningNumberCount() {
        return winningNumberCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public int getPrize() {
        return prize;
    }
}
