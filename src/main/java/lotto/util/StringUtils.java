package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        if (NUMBER_ALLOWED_PATTERN.matcher(target.trim()).find()) {
            return false;
        }

        return true;
    }

    public static List<Integer> convertNumbersStringToList(String target) {
        validateMultipleIntegerNumbers(target);

        return Arrays.stream(target.split(NUMBER_SEPARATOR)).map(s -> Integer.parseInt(s.trim())).toList();
    }

    private static void validateMultipleIntegerNumbers(String target) {
        Set<String> nonNumerics = Arrays.stream(target.split(NUMBER_SEPARATOR))
                .filter(str -> !isNumeric(str))
                .collect(Collectors.toSet());
        if (!nonNumerics.isEmpty()) {
            throw new IllegalArgumentException(createErrorMessage("숫자와 콤마(,)만 입력해주세요."));
        }
    }

    public static String createErrorMessage(String message) {
        return ERROR_MESSAGE_PREFIX + message;
    }
}
