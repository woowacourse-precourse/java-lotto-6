package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringUtils {
    private static final Pattern NUMBER_ALLOWED_PATTERN = Pattern.compile("\\D");
    private static final String NUMBER_SEPARATOR = ",";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private StringUtils() {

    }

    public static void validateBlank(String target) {
        if (target.isBlank()) {
            throw new IllegalArgumentException(createErrorMessage("공백 빈 문자열을 입력할 수 없습니다."));
        }
    }

    public static boolean isNumeric(String target) {
        if (NUMBER_ALLOWED_PATTERN.matcher(target).find()) {
            return false;
        }

        return true;
    }

    public static List<Integer> convertNumbersStringToList(String target) {
        validateIntegerNumbers(target);

        return Arrays.stream(target.split(NUMBER_SEPARATOR)).map(Integer::parseInt).toList();
    }

    private static void validateIntegerNumbers(String target) {
        try {
            Arrays.stream(target.split(NUMBER_SEPARATOR)).mapToInt(Integer::parseInt);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(createErrorMessage("숫자와 콤마(,)만 입력해주세요."));
        }
    }

    public static String createErrorMessage(String message) {
        return ERROR_MESSAGE_PREFIX + message;
    }
}
