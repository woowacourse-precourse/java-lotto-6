package lotto.domain;


import static lotto.constant.NumberConstant.*;

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

    public double calculateEarningsRate(final LottoGame lottoGame) {
        int buyingAmount = lottoGame.getBuyingAmount();
        int buyingPrice = buyingAmount * BUYING_PRICE_UNIT;
        double totalPrize = calculateTotalPrize();

        return (totalPrize / buyingPrice) * PERCENTAGE_UNIT;
    }

    private double calculateTotalPrize() {
        double firstPrize = rank1 * FIRST_PRIZE;
        double secondPrize = rank2 * SECOND_PRIZE;
        double thirdPrize = rank3 * THIRD_PRIZE;
        double fourthPrize = rank4 * FOURTH_PRIZE;
        double fifthPrize = rank5 * FIFTH_PRIZE;

        return firstPrize + secondPrize + thirdPrize + fourthPrize + fifthPrize;
    }

    private void winningRank1(final int correctAmount) {
        if (correctAmount == FIRST_CORRECT_AMOUNT) {
            rank1++;
        }
    }

    private void winningRank2(final int correctAmount, final boolean bonusCorrect) {
        if (correctAmount == SECOND_CORRECT_AMOUNT && bonusCorrect) {
            rank2++;
        }
    }

    private void winningRank3(final int correctAmount, final boolean bonusCorrect) {
        if (correctAmount == THIRD_CORRECT_AMOUNT && !bonusCorrect) {
            rank3++;
        }
    }

    private void winningRank4(final int correctAmount) {
        if (correctAmount == FOURTH_CORRECT_AMOUNT) {
            rank4++;
        }
    }

    private void winningRank5(final int correctAmount) {
        if (correctAmount == FIFTH_CORRECT_AMOUNT) {
            rank5++;
        }
    }

    // getter
    public int getRank1() {
        return rank1;
    }

    public int getRank2() {
        return rank2;
    }

    public int getRank3() {
        return rank3;
    }

    public int getRank4() {
        return rank4;
    }

    public int getRank5() {
        return rank5;
    }
}
