package lotto.view;

import lotto.view.constants.PrintMessage;

public class OutputView {
    public static void requestPurchaseAmountMessage() {
        System.out.println(PrintMessage.REQUEST_PURCHASE_AMOUNT);
    }

    public static void requestWinningNumberMessage() {
        System.out.println(PrintMessage.REQUEST_WINNING_NUMBER);
    }

    public static void requestBonusNumberMessage() {
        System.out.println(PrintMessage.REQUEST_BONUS_NUMBER);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static String returnLottery() {
        // 로또 개수 + 각 로또 번호
        return PrintMessage.RETURN_LOTTO_AMOUNT.toString();
    }

    public static String returnWinningStats() {
        // 일치 개수 + 수익률
        return "";
    }
}
