package lotto.exception;

import static lotto.type.ExceptionMessage.NOT_NUMBER;

public class WinningNumberException {

    public void validate(String[] inputNumbers) {
        word(inputNumbers);
    }

    public void word(String[] inputNumbers) {
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
