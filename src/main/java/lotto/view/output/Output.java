package lotto.view.output;

import java.text.NumberFormat;
import java.util.List;
import lotto.domain.Result;

public class Output {

    private static final String NEW_LINE = "%n";

    public static void printMessage(OutputMessage outputMessage) {
        System.out.println(outputMessage.message);
    }

    public static void printMessage(OutputMessage outputMessage, long messageValue) {
        System.out.printf((outputMessage.message) + NEW_LINE, messageValue);
    }

    public static void printTotalRateMessage(OutputMessage outputMessage, double rate) {
        System.out.printf((outputMessage.message) + NEW_LINE, rate);
    }

    public static void printResultMessage(Result result, int count) {
        String formattedReward = formatReward(result.getReward());
        System.out.printf((OutputMessage.CORRESPONDENCE_LOTTERY.message) + NEW_LINE, result.getMention(),
                formattedReward,
                count);
    }

    public static void printPurchasedLottery(List<List<Integer>> lotteries) {
        lotteries.forEach(System.out::println);
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void println() {
        System.out.println();
    }

    private static String formatReward(long reward) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(reward);
    }

}
