package common;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Convert {
    private static final String NON_INTEGER_INPUT_ERROR_MESSAGE = "[ERROR] 숫자를 입력해야 합니다";

    public static int stringToInteger(String src) {
        try {
            return Integer.parseInt(src);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_INPUT_ERROR_MESSAGE);
        }
    }

    public static List<Integer> splitByComma(String src) {
        StringTokenizer st = new StringTokenizer(src, ",");
        List<Integer> winningNumber = new ArrayList<>();
        while (st.hasMoreTokens()) {
            winningNumber.add(stringToInteger(st.nextToken()));
        }
        return winningNumber;
    }

    public static String formatWithCommaAndRound(double revenueRate) {
        return new DecimalFormat("#,##0.0").format(revenueRate);
    }
}
