package lotto.domain;


import static lotto.constant.NumberConstant.*;

public final class WinningResult {

    private int rank1;
    private int rank2;
    private int rank3;
    private int rank4;
    private int rank5;

    private WinningResult() {
    }

    public static WinningResult create() {
        return new WinningResult();
    }

    public void winRank(final int correctAmount, final boolean bonusCorrect) {
        winRank1(correctAmount);
        winRank2(correctAmount, bonusCorrect);
        winRank3(correctAmount, bonusCorrect);
        winRank4(correctAmount);
        winRank5(correctAmount);
    }

    public double calculateEarningsRate(final LottoGame lottoGame) {
        int buyingAmount = lottoGame.getBuyingAmount();
        int buyingPrice = buyingAmount * BUYING_PRICE_UNIT;
        double totalPrize = calculateTotalPrize();

        return (totalPrize / buyingPrice) * PERCENTAGE_UNIT;
    }

    private double calculateTotalPrize() {
        double totalFirstPrize = rank1 * FIRST_PRIZE;
        double totalSecondPrize = rank2 * SECOND_PRIZE;
        double totalThirdPrize = rank3 * THIRD_PRIZE;
        double totalFourthPrize = rank4 * FOURTH_PRIZE;
        double totalFifthPrize = rank5 * FIFTH_PRIZE;

        return totalFirstPrize + totalSecondPrize + totalThirdPrize + totalFourthPrize + totalFifthPrize;
    }

    private void winRank1(final int correctAmount) {
        if (correctAmount == FIRST_CORRECT_AMOUNT) {
            rank1++;
        }
    }

    private void winRank2(final int correctAmount, final boolean bonusCorrect) {
        if (correctAmount == SECOND_CORRECT_AMOUNT && bonusCorrect) {
            rank2++;
        }
    }

    private void winRank3(final int correctAmount, final boolean bonusCorrect) {
        if (correctAmount == THIRD_CORRECT_AMOUNT && !bonusCorrect) {
            rank3++;
        }
    }

    private void winRank4(final int correctAmount) {
        if (correctAmount == FOURTH_CORRECT_AMOUNT) {
            rank4++;
        }
    }

    private void winRank5(final int correctAmount) {
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
