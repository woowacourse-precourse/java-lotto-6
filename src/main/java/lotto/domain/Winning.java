package lotto.domain;

public enum Winning {
    NOT_WINNING(0, new Amount(0)),
    THIRD(3, new Amount(5_000)),
    FOURTH(4, new Amount(50_000)),
    FIFTH(5, new Amount(1_500_000)),
    FIFTH_BONUS(7, new Amount(30_000_000)),
    SIXTH(6, new Amount(2_000_000_000));

    private final int matchCount;
    private final Amount winningAmount;

    Winning(int matchCount, Amount winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Amount getWinningAmount() {
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
