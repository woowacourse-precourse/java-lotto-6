package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputUtil {

    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";
    public static final String EMPTY = "";
    private InputUtil() {}

    public static String readLineByNumber() {
        String readLine = EMPTY;
        try {
            readLine = Console.readLine();
            validInputNumber(readLine);
        } catch(IllegalArgumentException e) {
            OutputUtil.println(e.getMessage());
            readLineByNumber();
        }
        return readLine;
    }

    public static String readLine() {
        return Console.readLine();
    }

    public static int convert(String value) {
        validInputNumber(value);
        return Integer.parseInt(value);
    }
    private static void validInputNumber(String readLine) {
        if (!Pattern.matches(REGEXP_PATTERN_NUMBER, readLine)) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자만 올 수 있습니다.");
        }
    }
}
