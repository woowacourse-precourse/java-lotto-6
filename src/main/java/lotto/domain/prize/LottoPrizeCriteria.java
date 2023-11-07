package lotto.domain.prize;

public class LottoPrizeCriteria {

    private final int winningNumberCount;
    private final boolean needToMatchBonusNumber;

    public LottoPrizeCriteria(int numberMatchCount, boolean needToMatchBonusNumber) {
        this.winningNumberCount = numberMatchCount;
        this.needToMatchBonusNumber = needToMatchBonusNumber;
    }

    public boolean matchesWinningNumberCount(int winningNumberCount) {
        return this.winningNumberCount == winningNumberCount;
    }

    public boolean needToMatchBonusNumber(boolean matchesBonusNumber) {
        return this.needToMatchBonusNumber == matchesBonusNumber;
    }

    public int getWinningNumberCount() {
        return winningNumberCount;
    }

    public boolean needToMatchBonusNumber() {
        return needToMatchBonusNumber;
    }

}
