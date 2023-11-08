package lotto.util;

import static lotto.error.message.InvalidStateErrorMessage.UNKNOWN_ERROR_MESSAGE;

import lotto.error.exception.InvalidStateException;

public class IntegerUtil {

    public static boolean checkNumberInRange(Integer number, Integer from, Integer to) {
        if (number == null || from == null || to == null) {
            throw new InvalidStateException(UNKNOWN_ERROR_MESSAGE.getMessage());
        }

        if (number < from || number > to) {
            return false;
        }
        return true;
    }
}
