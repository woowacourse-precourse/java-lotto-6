package lotto.utils;

import lotto.input.InputErrorMessage;

public class Utils {
    
    public static Integer convertStringToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorMessage.NOT_INTEGER.getValue());
        }
    }

}
