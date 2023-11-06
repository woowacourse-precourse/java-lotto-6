package lotto.view;

import java.util.List;

public class OutputView {
    private static final String COMMA = ",";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(List<Integer> lotto) {
        String message = LEFT_BRACKET + String.join(COMMA, lotto.toString())
                + RIGHT_BRACKET;
        printMessage(message);
    }
}
