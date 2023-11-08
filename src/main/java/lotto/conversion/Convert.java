package lotto.conversion;

import static lotto.constant.ErrorMessage.ONLY_NUMBERS_ALLOWED;
import static lotto.constant.ErrorMessage.ONLY_NUMBERS_COMMA_ALLOWED;

import java.util.Arrays;
import java.util.List;

public class Convert {

    public static long toPrice(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBERS_ALLOWED.getMessage());
        }
    }

    public static List<Integer> toNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBERS_COMMA_ALLOWED.getMessage());
        }
    }

    public static int toBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBERS_ALLOWED.getMessage());
        }
    }
}
