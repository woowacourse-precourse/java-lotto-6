package lotto.view;

import java.util.List;
import lotto.constants.GameMessage;
public class OutputView {
    public static void printPayInputMessage() {
        System.out.println(GameMessage.PAY_INPUT_MESSAGE.getMessage());
    }

    public static void printPayOutputMessage(int count) {
        System.out.printf(GameMessage.PAY_OUTPUT_MESSAGE.getMessage(), count);
        System.out.println();
    }

    public static void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printWinningNumberMessage() {
        System.out.println(GameMessage.WINNING_NUMBER_MESSAGE.getMessage());
    }

    public static void printBonusNumberMessage() {
        System.out.println(GameMessage.BONUS_NUMBER_MESSAGE.getMessage());
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printStatisticsMessage(String statistics) {
        System.out.println(GameMessage.STATISTICS_MESSAGE.getMessage());
        System.out.println("---");
        System.out.println(statistics);
    }

    public static void printProfitMessage(double profit) {
        System.out.printf(GameMessage.RESULT_MESSAGE.getMessage(), profit);
        System.out.println();
    }
}
