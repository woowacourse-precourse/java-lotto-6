package lotto.view;

import lotto.constant.ErrorMessage;
import lotto.constant.GeneralMessage;

import static lotto.constant.GeneralMessage.NOTIFY_BUY_COUNT;
import static lotto.constant.GeneralMessage.NOTIFY_WINNING_STATISTICS;

public class OutputView {
    public static void printGeneralMessage(GeneralMessage generalMessage, Object... args) {
        System.out.printf(generalMessage.getMessage(), args);
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.print(ErrorMessage.PREFIX);
        System.out.println(message);
    }

    public static void printBuyLottos(int count, String tickets) {
        System.out.printf(NOTIFY_BUY_COUNT.getMessage(), count);
        System.out.println();
        System.out.println(tickets);
        System.out.println();
    }

    public static void printWinningStatistics(String result) {
        System.out.println(NOTIFY_WINNING_STATISTICS.getMessage());
        System.out.println();
        System.out.println(result);
    }
}
