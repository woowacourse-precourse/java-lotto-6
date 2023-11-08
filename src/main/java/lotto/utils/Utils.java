package lotto.utils;

import lotto.domain.ErrorMessage;

public class Utils {

    public static Integer convertStringToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getValue());
        }
    }

}
