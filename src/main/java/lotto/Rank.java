package lotto;

public enum Rank {
    FOURTH,
    FIFTH,
    THIRD,
    SECOND,
    FIRST,
    NONE;

    public static Rank of(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = lotto.match(winningNumber.getWinningLotto());
        boolean hasBonusNumber = lotto.has(winningNumber.getBonusNumber());
        return Rank.of(matchCount, hasBonusNumber);
    }

    private static Rank of(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 3) {
            return Rank.FIFTH;
        }
        if (matchCount == 4) {
            return Rank.FOURTH;
        }
        if (matchCount == 5 && !hasBonusNumber) {
            return Rank.THIRD;
        }
        if (matchCount == 5) {
            return Rank.SECOND;
        }
        if (matchCount == 6) {
            return Rank.FIRST;
        }
        return NONE;
    }
}
