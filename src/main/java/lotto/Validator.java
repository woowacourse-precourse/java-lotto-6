package lotto;

import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class Validator {
    private static final int LOTTO_SIZE = 6;

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsDuplicationExists(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsInteger(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException();
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