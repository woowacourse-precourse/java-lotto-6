package lotto.util;

public class NumberUtils {

    private NumberUtils() {

    }

    public static int checkNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }
}
