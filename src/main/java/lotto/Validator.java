package lotto;

import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class Validator {
    private static final int LOTTO_SIZE = 6;

    private enum ErrorMessage {
        INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6자리여야 합니다."),
        DUPLICATION_EXIST("[ERROR] 로또 번호에는 중복되는 숫자가 없어야 합니다."),
        BLANK_OR_WHITE_SPACE("[ERROR] 빈값 혹은 공백입니다. 올바른 값을 입력해주세요."),
        NOT_INTEGER("[ERROR] 양의 정수만 입력해주세요");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }
    }

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.message);
        }
    }

    public static void validateIsDuplicationExists(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_EXIST.message);
        }
    }

    public static void validateIsBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_OR_WHITE_SPACE.message);
        }
    }

    public static void validateIsInteger(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.message);
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}