package lotto.view;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final String BOUNDARY_LINE = "--------------------------------------------------------";
    private static final String BUY_RESULT_MESSAGE = "%d개를 구매했습니다. \n";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %s%%입니다. \n";

    public static void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println(BOUNDARY_LINE);
        System.out.println();
    }

    public static void printBuyResults(List<String> buyResults) {
        System.out.println();
        System.out.printf((BUY_RESULT_MESSAGE), buyResults.size());
        buyResults.forEach(buyResult -> System.out.println("[" + buyResult + "]"));
    }

    public static void printWinningResult(List<String> winningResults) {
        System.out.println();
        winningResults.forEach(System.out::println);
    }

    public static void printRateOfReturn(Double rateOfReturn) {
        DecimalFormat formatter = new DecimalFormat("###,###.0");
        System.out.printf((RATE_OF_RETURN_MESSAGE), formatter.format((double)rateOfReturn));
    }
}
