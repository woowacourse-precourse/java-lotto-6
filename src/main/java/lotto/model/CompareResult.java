package lotto.model;

public class CompareResult {
    int winningNumberMatchCount;
    boolean bonusMatch;

    public CompareResult() {
        winningNumberMatchCount = 0;
        bonusMatch = false;
    }

    public CompareResult(int winningNumberMatchCount, boolean bonusMatch) {
        this.winningNumberMatchCount = winningNumberMatchCount;
        this.bonusMatch = bonusMatch;
    }

    public void updateWinningNumberMatchCount() {
        winningNumberMatchCount++;
    }

    public void updateBonusMatch(boolean isMatch) {
        bonusMatch = isMatch;
    }

    public int getWinningNumberMatchCount() {
        return winningNumberMatchCount;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }
}

