package lotto.domain;

import lotto.constant.NumberConstant;

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
        int totalPrize = calculateTotalPrize();

        return (double) totalPrize / buyingPrice;
    }

    private int calculateTotalPrize() {
        int firstPrize = rank1 * FIFTH_PRIZE;
        int secondPrize = rank2 * SECOND_PRIZE;
        int thirdPrize = rank3 * THIRD_PRIZE;
        int fourthPrize = rank4 * FOURTH_PRIZE;
        int fifthPrize = rank5 * FIFTH_PRIZE;

        return firstPrize + secondPrize + thirdPrize + fourthPrize + fifthPrize;
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
