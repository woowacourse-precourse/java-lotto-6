package lotto.domain;

public class Result {
    private final int matchWinningNumbers;
    private final boolean matchBonusNumber;

    public Result(int matchWinningNumbers, boolean matchBonusNumber) {
        this.matchWinningNumbers = matchWinningNumbers;
        this.matchBonusNumber = matchBonusNumber;
    }

    public int getMatchWinningNumbers() {
        return matchWinningNumbers;
    }

    public boolean isMatchBonusNumber() {
        return matchBonusNumber;
    }

    @Override
    public String toString() {
        return "{" + matchWinningNumbers +
                ", " + matchBonusNumber +
                '}';
    }
}
