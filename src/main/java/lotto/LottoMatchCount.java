package lotto;

public class LottoMatchCount {
    private int winningNumberMatch;
    private int bonusNumberMatch;

    public void resetCount() {
        winningNumberMatch = 0;
        bonusNumberMatch = 0;
    }

    public void plusWinningMatchCount() {
        winningNumberMatch++;
    }

    public void plusBonusMatchCount() {
        bonusNumberMatch++;
    }

    public int getWinningNumberMatch() {
        return winningNumberMatch;
    }

    public int getBonusNumberMatch() {
        return bonusNumberMatch;
    }
}
