package lotto.view;

import java.util.List;

public class OutputView {

    private static final String OUTPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String OUTPUT_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String OUTPUT_WINNER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String OUTPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String BLANK_LINE = "";
    private static final String OUTPUT_WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String OUTPUT_DIVIDING_LINE = "---";

    public static void printSuccessMessage(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }

    public void printPurchaseMoneyMessage() {
        System.out.println(OUTPUT_PURCHASE_MONEY_MESSAGE);
    }

    public void printLottoCountMessage(int ammount) {
        System.out.printf(OUTPUT_LOTTO_COUNT_MESSAGE, ammount);
    }

    public void printWinnerNumberMessage() {
        System.out.println(OUTPUT_WINNER_NUMBER_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(OUTPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printBlankLine() {
        System.out.println(BLANK_LINE);
    }

    public void printPurchaseLottoNumbers(List<List<Integer>> purchaseLottoNumbers) {
        purchaseLottoNumbers.forEach(purchaseLottoNumber -> System.out.println(purchaseLottoNumber.toString()));
    }

    public void printWinningStaticsMessage() {
        System.out.println(OUTPUT_WINNING_STATISTICS_MESSAGE);
        System.out.println(OUTPUT_DIVIDING_LINE);
    }

    public void printRevenueRate(double earningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.");
    }
}
