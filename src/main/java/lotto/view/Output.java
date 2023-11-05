package lotto.view;

import static java.lang.System.out;

import java.util.List;
import lotto.model.Lotto;

public class Output {
    public static void inputAmountMsg() {
        out.println(Message.INPUT_AMOUNT.getMessage());
    }

    public static void printNumOfLotto(int numOfLotto) {
        String message = String.format(Message.NUM_OF_LOTTO.getMessage(), numOfLotto / 1000);
        out.println("\n" + message);
    }

    public static void printTicket(List<Lotto> ticket) {
        for (Lotto lotto : ticket) {
            out.println(lotto.getNumbers().toString());
        }
    }

    public static void inputWinningNumMsg() {
        out.println("\n" + Message.INPUT_WINNING_NUM.getMessage());
    }

    public static void inputBonusNumMsg() {
        out.println("\n" + Message.INPUT_BONUS_NUM.getMessage());
    }

    public static void printResult(int[]resultCount, double rateOfReturn) {
        out.println("\n" + Message.OUTPUT_RESULT.getMessage());
        printSame3(resultCount[0]);
        printSame4(resultCount[1]);
        printSame5(resultCount[2]);
        printSame5Bonus(resultCount[3]);
        printSame6(resultCount[4]);
        out.println(String.format(Message.RATE_OF_RETURN.getMessage(), rateOfReturn));
    }

    private static void printSame3(int count) {
        out.println(String.format(Message.SAME3.getMessage(), count));
    }

    private static void printSame4(int count) {
        out.println(String.format(Message.SAME4.getMessage(), count));
    }

    private static void printSame5(int count) {
        out.println(String.format(Message.SAME5.getMessage(), count));
    }

    private static void printSame5Bonus(int count) {
        out.println(String.format(
            Message.SAME5_BONUS.getMessage(), count));
    }

    private static void printSame6(int count) {
        out.println(String.format(Message.SAME6.getMessage(), count));
    }
}
