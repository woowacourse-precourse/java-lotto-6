package lotto.domain;

public class MatchResult {
    private final int matchNumbersCount;
    private final boolean hasBonusNumber;

    private MatchResult(int matchNumbersCount, boolean hasBonusNumber) {
        this.matchNumbersCount = matchNumbersCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static MatchResult of(int matchNumbersCount, boolean hasBonusNumber) {
        return new MatchResult(matchNumbersCount, hasBonusNumber);
    }

    public static MatchResult of(Lotto purchasedLotto, WinningNumbersWithBonus winningNumbersWithBonus) {
        return new MatchResult(winningNumbersWithBonus.countMatchingNumbers(purchasedLotto),
                winningNumbersWithBonus.bonusIn(purchasedLotto));
    }

    public boolean isEqaulMatchNumbersCount(int matchNumbersCount) {
        return this.matchNumbersCount == matchNumbersCount;
    }

    public boolean isEqaulHasBonusNumber(boolean hasBonusNumber) {
        return this.hasBonusNumber == hasBonusNumber;
    }
}
