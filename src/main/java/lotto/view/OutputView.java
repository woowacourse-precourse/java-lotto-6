package lotto.view;

import java.util.List;

import static lotto.view.Message.*;

public class OutputView {
    public static void purchaseConfirmationMessage(int numberOfLottoPurchased) {
        System.out.println(numberOfLottoPurchased + BUY.getMessage());
    }

    public static void showLottoes(List<Integer> lottoes) {
        for (Integer lotto : lottoes) {
            System.out.println(lotto.toString());
        }
    }

    public static void winningStaticsMessage(List<Integer> agreementCounts) {
        int agreementThreeCount = agreementCounts.get(0);
        int agreementFourCount = agreementCounts.get(1);
        int agreementFiveCount = agreementCounts.get(2);
        int agreementFiveAndBonusCount = agreementCounts.get(3);
        int agreementSixCount = agreementCounts.get(4);

        System.out.println();
        System.out.println(WINNING_STATISTICS.getMessage());
        System.out.println(DIVISION.getMessage());
        System.out.println(AGREEMENT_THREE_NUMBERS.getMessage()
                + agreementThreeCount
                + COUNT.getMessage());
        System.out.println(AGREEMENT_FOUR_NUMBERS.getMessage()
                + agreementFourCount
                + COUNT.getMessage());
        System.out.println(AGREEMENT_FIVE_NUMBERS.getMessage()
                + agreementFiveCount
                + COUNT.getMessage());
        System.out.println(AGREEMENT_FIVE_NUMBERS_AND_BONUS_NUMBER.getMessage()
                + agreementFiveAndBonusCount
                + COUNT.getMessage());
        System.out.println(AGREEMENT_SIX_NUMBERS.getMessage()
                + agreementSixCount
                + COUNT.getMessage());
    }

    public static void totalReturnMessage(float totalReturn) {
        System.out.println(TOTAL_RETURN_FIRST.getMessage()
                + totalReturn
                + TOTAL_RETURN_LAST.getMessage());
    }
}
