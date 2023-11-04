package lotto.view;

import java.util.List;

public class OutputView {

    // 구매 확정 메시지
    private static final String BUY_MESSAGE = "개를 구매했습니다.";
    // 당첨 통계 메시지
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVISION_MESSAGE = "---";
    private static final String AGREEMENT_THREE_NUMBERS_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String AGREEMENT_FOUR_NUMBERS_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String AGREEMENT_FIVE_NUMBERS_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String AGREEMENT_FIVE_NUMBERS_AND_BONUS_NUMBER_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String AGREEMENT_SIX_NUMBERS_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT_MESSAGE = "개";

    // 총 수익률 메시지
    private static final String TOTAL_RETURN_FIRST_MESSAGE = "총 수익률은 ";
    private static final String TOTAL_RETURN_LAST_MESSAGE = "입니다.";

    public static void purchaseConfirmationMessage(int numberOfLottoPurchased) {
        System.out.println(numberOfLottoPurchased + BUY_MESSAGE);
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
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVISION_MESSAGE);
        System.out.println(AGREEMENT_THREE_NUMBERS_MESSAGE + agreementThreeCount + COUNT_MESSAGE);
        System.out.println(AGREEMENT_FOUR_NUMBERS_MESSAGE + agreementFourCount + COUNT_MESSAGE);
        System.out.println(AGREEMENT_FIVE_NUMBERS_MESSAGE + agreementFiveCount + COUNT_MESSAGE);
        System.out.println(AGREEMENT_FIVE_NUMBERS_AND_BONUS_NUMBER_MESSAGE + agreementFiveAndBonusCount + COUNT_MESSAGE);
        System.out.println(AGREEMENT_SIX_NUMBERS_MESSAGE + agreementSixCount + COUNT_MESSAGE);
    }

    public static void totalReturnMessage(float totalReturn) {
        System.out.println(TOTAL_RETURN_FIRST_MESSAGE + totalReturn + TOTAL_RETURN_LAST_MESSAGE);
    }
}
