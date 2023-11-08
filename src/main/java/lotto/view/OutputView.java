package lotto.view;

import java.util.List;

public class OutputView {
    private static final String BOUNDARY_LINE = "--------------------------------------------------------";
    private static final String BUY_RESULT_MESSAGE = "%d개를 구매했습니다. \n";

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
}
