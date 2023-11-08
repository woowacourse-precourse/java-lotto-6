package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String MONEY_FORMAT = "###,###";
    private static final String COMMA = ",";

    private StringUtils() {
    }

    public static List<String> splitCommaToListString(String str) {
        return Arrays.stream(str.split(COMMA))
                .collect(Collectors.toList());
    }

    public static List<Integer> convertStringListToIntegerList(List<String> strings) {
        return strings.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    public static String convertToMoneyFormat(int money) {
        DecimalFormat decimalFormat = new DecimalFormat(MONEY_FORMAT);
        return decimalFormat.format(money);
    }

    public static boolean hasText(String str) {
        return str != null && !str.isEmpty() && containsText(str);
    }

    private static boolean containsText(String gameCount) {
        for (char ch : gameCount.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                return true;
            }
        }
        return false;
    }
}
