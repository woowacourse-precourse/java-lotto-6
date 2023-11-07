package lotto.util;

public class TypeConverter {
    private static final String WRONG_NUMBER_INPUT_MSG = "숫자만 입력해주세요.";

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_NUMBER_INPUT_MSG);
        }
    }
}
