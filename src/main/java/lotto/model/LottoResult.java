package lotto.model;

public class LottoResult {

    private int winningCount;
    private boolean bonusMatch;

    public LottoResult(int winningCount, boolean bonusMatch) {
        this.winningCount = winningCount;
        this.bonusMatch = bonusMatch;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
