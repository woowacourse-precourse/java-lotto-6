package lotto.utils;

public class NumberUtil {

    public static final String STRING_VALID_LOG = "숫자만 입력해주세요.";

    public static int parseInt(final String argument) {
        try {
            return Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(STRING_VALID_LOG);
        }
    }
}
