package lotto.domain;

public class WinningResult {

    private int rank1;
    private int rank2;
    private int rank3;
    private int rank4;
    private int rank5;

    public void winningRank(final int correctAmount, final boolean bonusCorrect) {
        winningRank1(correctAmount);
        winningRank2(correctAmount, bonusCorrect);
        winningRank3(correctAmount, bonusCorrect);
        winningRank4(correctAmount);
        winningRank5(correctAmount);
    }

    private void winningRank1(final int correctAmount) {
        if (correctAmount == 6) {
            rank1++;
        }
    }

    private void winningRank2(final int correctAmount, final boolean bonusCorrect) {
        if (correctAmount == 5 && bonusCorrect) {
            rank2++;
        }
    }

    private void winningRank3(final int correctAmount, final boolean bonusCorrect) {
        if (correctAmount == 5 && !bonusCorrect) {
            rank3++;
        }
    }

    private void winningRank4(final int correctAmount) {
        if (correctAmount == 4) {
            rank4++;
        }
    }

    private void winningRank5(final int correctAmount) {
        if (correctAmount == 3) {
            rank5++;
        }
    }
}
