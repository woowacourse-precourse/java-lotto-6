package lotto.exception;

import static lotto.type.ExceptionMessage.NOT_NUMBER;

public class WinningNumberException {

    public void word(String[] inputNumbers) {
        if (inputNumbers.length == 0) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
        for (int i = 0; i < inputNumbers.length; i++) {
            if (!isInteger(inputNumbers[i])) {
                throw new IllegalArgumentException(NOT_NUMBER.getMessage());
            }
        }
    }

    public static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
