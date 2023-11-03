package lotto.utils;

public class Utils {
    public static int parseIntValidate(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
