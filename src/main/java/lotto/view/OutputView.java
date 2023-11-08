package lotto.view;

import lotto.view.constants.PrintMessage;

public class OutputView {
    public static void requestPurchaseAmountMessage() {
        System.out.println(PrintMessage.REQUEST_PURCHASE_AMOUNT.getMessage());
    }

    public static void requestWinningNumberMessage() {
        System.out.println(PrintMessage.REQUEST_WINNING_NUMBER.getMessage());
    }

    public static void requestBonusNumberMessage() {
        System.out.println(PrintMessage.REQUEST_BONUS_NUMBER.getMessage());
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void returnLottery(int lottoAmount, String lottoList) {
        System.out.println(lottoAmount
                +PrintMessage.RETURN_LOTTO_AMOUNT.getMessage()
                +"\n"
                +lottoList);
    }

    public static void returnWinningStats(String winningLottoList) {
        System.out.println(PrintMessage.RETURN_LOTTO_STATS.getMessage() + winningLottoList);
    }
}
