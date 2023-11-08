package lotto.utils;

public class IntegerParser {

    public static Integer stringToInteger(final String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자열이 정수가 아닙니다.");
        }
    }
}
