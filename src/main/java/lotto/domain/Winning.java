package lotto.domain;

public enum Winning {
    NOT_WINNING(0, 0),
    THIRD(3, 5_000),
    FOURTH(4, 50_000),
    FIFTH(5, 1_500_000),
    FIFTH_BONUS(7, 30_000_000),
    SIXTH(6, 2_000_000_000);

    private final int matchCount;
    private final int winningAmount;

    Winning(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static Winning checkWinning(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return Winning.SIXTH;
        }
        if (matchCount == 5 && bonusMatch) {
            return Winning.FIFTH_BONUS;
        }
        if (matchCount == 5) {
            return Winning.FIFTH;
        }
        if (matchCount == 4) {
            return Winning.FOURTH;
        }
        if (matchCount == 3) {
            return Winning.THIRD;
        }
        return Winning.NOT_WINNING;
    }
}
