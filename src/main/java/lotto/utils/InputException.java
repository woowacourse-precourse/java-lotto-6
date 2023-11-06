package lotto.utils;

import lotto.domain.PrintMessage;

public class InputException {

    public static void isDigit(String input) {
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException(PrintMessage.ONLY_DIGIT);
            }
        }
    }

    public static void isThousandUnit(int num) {
        if (num % 1000 != 0)
            throw new IllegalArgumentException(PrintMessage.ONLY_THOUSAND_UNIT);
    }

}
