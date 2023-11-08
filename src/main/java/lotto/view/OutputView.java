package lotto.view;

import static lotto.config.SystemNumberConfig.LINE_REPEAT;
import static lotto.config.SystemNumberConfig.START_NUM;
import static lotto.message.Message.BONUS_NUMBER_REQUEST;
import static lotto.message.Message.COUNT;
import static lotto.message.Message.DIVIDING_LINE;
import static lotto.message.Message.END_EXPLAINE;
import static lotto.message.Message.PAYMENT_COMPLETE;
import static lotto.message.Message.PAYMENT_REQUEST;
import static lotto.message.Message.PERCENT_SIGN;
import static lotto.message.Message.SPACE;
import static lotto.message.Message.TOTAL_RETURN;
import static lotto.message.Message.WINNING_NUMBER_REQUEST;
import static lotto.message.Message.WINNING_STATISTICS_RESULT;

public class OutputView {
    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void printPayRequest() {
        System.out.println(PAYMENT_REQUEST.getMessage());
    }

    public static void printLottoCount(String count) {
        System.out.println();
        System.out.print(count);
        System.out.println(PAYMENT_COMPLETE.getMessage());
    }

    public static void printWinNumberRequest() {
        System.out.println();
        System.out.println(WINNING_NUMBER_REQUEST.getMessage());
    }

    public static void printBonusRequest() {
        System.out.println();
        System.out.println(BONUS_NUMBER_REQUEST.getMessage());
    }

    public static void printNoticeWiningResult() {
        System.out.println();
        System.out.println(WINNING_STATISTICS_RESULT.getMessage());
        for (int i = START_NUM.getConfig(); i < LINE_REPEAT.getConfig(); i++) {
            System.out.print(DIVIDING_LINE.getMessage());
        }
        System.out.println();
    }

    public static void printWiningResult(int count, String explaine) {
        System.out.println(explaine + SPACE.getMessage() + DIVIDING_LINE.getMessage() + SPACE.getMessage()
                + count + COUNT.getMessage());
    }

    public static void printStatisticResult(String statistic) {
        System.out.println(
                TOTAL_RETURN.getMessage() + statistic + PERCENT_SIGN.getMessage() + END_EXPLAINE.getMessage());
    }

}
