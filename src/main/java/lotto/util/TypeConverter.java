package lotto.util;

import lotto.view.ErrorMessage;

public class TypeConverter {
    public static Integer StringToInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE.getErrorMessage());
        }
    }
}
