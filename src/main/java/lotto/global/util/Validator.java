package lotto.global.util;

import java.util.regex.Pattern;

public class Validator {
    private final static Pattern INT_FORMAT = Pattern.compile("\\d+");

    public static void validateIntFormat(String value) {
        if (!INT_FORMAT.matcher(value).matches()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 정수 형태가 아닙니다.");
        }
    }

    public static void validateIntFormat(String[] values) {
        for (String value : values) {
            validateIntFormat(value);
        }
    }
}
