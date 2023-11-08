package lotto.conversion;

import static lotto.constant.ErrorMessage.ONLY_NUMBERS_ALLOWED;

public class Convert {

    public static long toPrice(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBERS_ALLOWED.getMessage());
        }
    }
}
